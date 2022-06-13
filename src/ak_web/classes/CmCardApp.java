package ak_web.classes;

/***********************************************************************
 * 문화아카데미 카드승인모듈 CmCardApp.java
 ***********************************************************************/
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class CmCardApp {

    public Socket socket = null;
    public String host = null;
    public int port = 0;
    public String approve_no  = null;
    public String return_msg  = null;
    public String vensa_fg    = null;
    public String card_inform = null;
    boolean DEBUG = true; 
    
    public String return_add  = null;

    BufferedReader inB  = null;
    PrintWriter toServer = null;

    public void setHost(String host, int port) {

        if (DEBUG) {
            System.out.println("CmCardApp.setHost() called...");
        }

        if (host != null) {
            this.host = host;
        }

        if (port > 0) {
            this.port = port;
        }

    }



    public String start() {

        if (DEBUG) {
            System.out.println("CmCardApp.start() called...");
        }

        try {
            socket = new Socket(host, port);

            if (socket != null) {
                inB  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                toServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                return "OK";
            } else {
                if (DEBUG) {
                    System.out.println("Fail0000:시스템장애(Exception:In/Out Socket Streams...)");
                }
                return "Fail0000:시스템장애(Exception:In/Out Socket Streams...)";
            }

        } catch ( UnknownHostException e ) {
            if (DEBUG) {
                System.out.println("Fail0000:시스템장애(UnknownHostException):"+host);
            }
            return "Fail0000:시스템장애(UnknownHostException):" + host;
        } catch ( IOException e ) {
            if (DEBUG) {
                System.out.println("Fail0000:시스템장애(IOException):" + host+":"+port);
            }
            return "Fail0000:시스템장애(IOException):" + host+":"+port;
        }


    }

    public void setCardStmt(String hq, String store, String cardno, String validdt, String halbu, String amt ,String card_pwd, String card_chk_value)
    {
        if (DEBUG) {
            System.out.println("CmCardApp.setCardStmt() called...");
        }

        // card-전문생성 card_header 에서 card_co_orseq까지는 고정된 값임.
        String card_header   = "XA071S0000       0       0       0       0";
        String card_hq       = hq;
        String card_store    = store;
        String card_pos_no   = "933001";
        String card_termid1  = "9047000000     ";
        String card_termid2  = "9540030001     ";
        String card_termid3  = "               ";
        String card_chkbilfg = "12"; //10 :무조건 인증 , 12 : 비밀번호 체크 인증
        String card_wcc      = "@";
        String card_co_orseq = "001";

        // client로 부터 입력받을 card정보
        String card_no       = cardno;
        String card_valid_dt = validdt;
        String card_instmm   = halbu;
        String card_pamt     = amt;
        String card_chk      = "=";
        String card_dataend  = "                ";
        String card_password = "";
        
        // 점별 가맹점 승인 정의
        if("01".equals(store)) {
            card_password = "DDDD";   
        } else if("02".equals(store)) {
            card_password = "EEEE";             
        } else if("03".equals(store)) {
        //기존소스 백업(13.06.09)  card_password = "BBBB";    
        //분당점 식품관가맹점 → 백화점가맹점으로 변경(13.06.09) GGGG 신규 추가  
            card_password = "GGGG";    
        } else if("04".equals(store)) { 
            card_password = "FFFF";	
	}	

        String card_amt      = "";

        String card_detail   = "";
        String card_blank    = "";

        //card_pwd	    = Common.MakeStringAfter(card_pwd, "9" , 4);
        //card_chk_value    = Common.MakeStringBefore(card_chk_value, " " , 13);
        card_pwd	    = Utils.RPAD(card_pwd, 4, '9');
        card_chk_value	= Utils.LPAD(card_chk_value, 13, ' ');      // 주민번호 

        int slength = card_no.length() + 5;
        String card_length = Integer.toString(slength);

        if ( slength < 21 ) {
            for ( int i = 1; i <= (21 - slength); i++) {
                card_dataend += " ";
            }
        }

        int slen = 11 - card_pamt.length();

        for ( int i = 1; i <= slen; i++) {
            card_amt   += "0";
        }

        card_amt += card_pamt;
        

        /* 기존소스 백업(2011.05.27) 
        card_detail = card_hq       + card_store    + card_pos_no   + card_termid1 +
                      card_termid2  + card_termid3  + card_chkbilfg + card_wcc     +
                      card_length   + card_co_orseq + card_no       + card_chk     +
                      card_valid_dt + card_dataend  + card_instmm   + card_amt     +
                      card_password + card_pwd      + card_chk_value;
        */   
        
        // 은련카드 승인전문 변경(2011.05.27) START -----------------------------------------------------
               
        String card_filler    = "";   						// filler : 예약 필드(2)
        card_filler = Utils.LPAD(card_filler, 2, ' ');
        
        String card_working   = "";   						// Working Key : 은련카드 비밀번호(16)
        card_working = Utils.LPAD(card_working, 16, ' ');
        
        String card_royalty   = "";   						// royalty : 로열티 데이터   (BC 파트너스) 부가세율(2) + 할인여부(1) + 로열티 Data + space 로열티 데이터는 POS API가 전달한 그대로의  Data값을 Setting (203)
        card_royalty = Utils.LPAD(card_royalty, 203, ' ');
        
        
        card_detail = card_hq       + card_store    + card_pos_no   + card_termid1 +
			          card_termid2  + card_termid3  + card_chkbilfg + card_wcc     +
			          card_length   + card_co_orseq + card_no       + card_chk     +
			          card_valid_dt + card_dataend  + card_instmm   + card_amt     +
			          card_password + card_pwd      + card_filler   + card_working  + card_royalty  + card_chk_value ;
        
        // 은련카드 승인전문 변경(2011.05.27)  END -----------------------------------------------------
        

        card_inform = card_header + card_detail;

        for (int i = 1; i <= (1024 - card_inform.length()); i++){
            card_blank  += " ";
        }

        card_inform += card_blank;
        
        System.out.println("card_inform : ["+card_inform+"]" );

    } // end of setCardStmt
    
    
    // 카드승인 취소 개발(12.06.07)
    public void setCancelCardStmt(String hq, String store, String cardno, String validdt, String halbu, String amt ,String card_chk_value, String org_ack_no, String org_sale_ymd, String van_fg )
    {
        if (DEBUG) {
            System.out.println("CmCardApp.setCancelCardStmt() called...");
            
            System.out.println("hq        >>>>>>>>>>>> :"+hq);
            System.out.println("store     >>>>>>>>>>>> :"+store);
            System.out.println("cardno    >>>>>>>>>>>> :"+cardno);
            System.out.println("validdt   >>>>>>>>>>>> :"+validdt);
            System.out.println("halbu     >>>>>>>>>>>> :"+halbu);
            System.out.println("amt       >>>>>>>>>>>> :"+amt);
            System.out.println("card_chk_value >>>>>>>>>>>> :"+card_chk_value);
            System.out.println("org_ack_no  >>>>>>>>>>>> :"+org_ack_no);
            System.out.println("org_sale_ymd >>>>>>>>>>>> :"+org_sale_ymd);
            System.out.println("van_fg >>>>>>>>>>>> :"+van_fg);
            
            
        }
 
        // card-전문생성 card_header 에서 card_co_orseq까지는 고정된 값임.
        String card_header   = "CA011S0000       0       0       0       0";
        
        if("02".equals(van_fg)) {                 // 카드승인벤사 02:나이스 (NICE)
            card_header   = "CA012S0000       0       0       0       0";
        }else if("03".equals(van_fg)) {           // 카드승인벤사 03:코벤   (KOVAN) 
            card_header   = "CA014S0000       0       0       0       0";  
        }
         
      
        String card_hq       = hq;
        String card_store    = store;
        String card_pos_no   = "933001";
        //String card_termid1  = "9047000000     ";
        //String card_termid2  = "9540030001     ";
        //String card_termid3  = "               ";
        String card_chkbilfg = "10"; //10 :무조건 인증 , 12 : 비밀번호 체크 인증
        String card_wcc      = "@";
        String card_co_orseq = "001";

        // client로 부터 입력받을 card정보
        String card_no       = cardno;
        String card_valid_dt = validdt;
        String card_instmm   = halbu;
        String card_pamt     = amt;
        String card_chk      = "=";
        String card_dataend  = "                ";
        
        String card_password = "";
  
        
        // 점별 가맹점 승인 정의
        if("01".equals(store)) {
            card_password = "DDDD";   
        } else if("02".equals(store)) {
            card_password = "EEEE";             
        } else if("03".equals(store)) {
            // 기존소스 백업(13.06.09)  card_password = "BBBB";        
            //분당점 식품관가맹점 → 백화점가맹점으로 변경(13.06.09) GGGG 신규 추가  
            card_password = "GGGG";
        } else if("04".equals(store)) { 
            card_password = "FFFF"; 
        }   

        String card_amt      = "";

        String card_detail   = "";
        String card_blank    = "";

        if (DEBUG) {
            System.out.println("card_no >>>>>>>>>>>> :"+card_no);
            System.out.println("cardno  >>>>>>>>>>>> :"+cardno);
            System.out.println("cardno.length() + 5  >>>>>>>>>>>> :"+cardno.length() + 5);
        }

        int slength = cardno.length() + 5;
        String card_length = Integer.toString(slength);

        if ( slength < 21 ) {
            for ( int i = 1; i <= (21 - slength); i++) {
                card_dataend += " ";
            }
        }

        int slen = 11 - card_pamt.length();

        for ( int i = 1; i <= slen; i++) {
            card_amt   += "0";
        }

        card_amt += card_pamt;
        
       
        card_detail = card_hq     + card_store    + card_pos_no   + card_chkbilfg + card_wcc     +
                      card_length   + card_co_orseq + card_no       + card_chk     +
                      card_valid_dt + card_dataend  + card_instmm   + card_amt     +
                      card_password + org_ack_no    + org_sale_ymd ;
        

        card_inform = card_header + card_detail;

        for (int i = 1; i <= (1024 - card_inform.length()); i++){
            card_blank  += " ";
        }

        card_inform += card_blank;
        
        System.out.println("card_inform : ["+card_inform+"]" );

    } // end of setCancelCardStmt


    public String run(){
        
        if (DEBUG) {
            System.out.println("CmCardApp.run() called...");
        }

        String line = null;
        String TranHeader = null;

        try {

            //서버에 카드정보를 보냄
            toServer.println(card_inform);
            toServer.flush();

            //승인여부를 받아옴
            while ( (line = inB.readLine()) != null ) {
                if (line.length() == 0) {
                    break;
                }
                TranHeader = line.substring(0, 6);
                approve_no = line.substring(42, 50);
                vensa_fg   = line.substring(68, 70);
                return_msg = line.substring(70, 110);
                
                // 선불카드, 은련카드, BC파트너스 차후 진행시 고려하여 추가(11.05.27)
                return_add = line.substring(110, 464);              
                                
            }

            //정상적인경우
            if (TranHeader.equals("XA071R")) {
                // backup (11.05.27) return approve_no + vensa_fg+return_msg ;
            	return approve_no + vensa_fg+return_msg + return_add;

            } else {
                if (DEBUG) {
                    System.out.println("CmCardApp.run():시스템장애(TranHeader:XA071R오류)");
                }
                return "Fail0000:시스템장애(TranHeader:XA071R오류)";
            }

        } catch (SocketException e) {
            if (DEBUG) {
                System.out.println("CmCardApp.run():시스템장애(SocketException)");
            }
            return "Fail0000:시스템장애(SocketException)";
        } catch (IOException e) {
            if (DEBUG) {
                System.out.println("CmCardApp.run():시스템장애(IOException)");
            }
            return "Fail0000:시스템장애(IOException)";
        } catch (NullPointerException e) {
            if (DEBUG) {
                System.out.println("CmCardApp.run():시스템장애(NullPointerException)");
            }
            return "Fail0000:시스템장애(NullPointerException)";
        } catch (Exception e) {
            if (DEBUG) {
                System.out.println("CmCardApp.run():시스템장애(Exception)");
            }
            return "Fail0000:시스템장애(Exception)";
        }
    }

    public void stop() {
        if (DEBUG) {
            System.out.println("CmCardApp.stop() called...");
        }

        try {
            if (inB != null) {
                inB.close();
                inB = null;
            }
            if (toServer != null) {
                toServer.close();
                toServer = null;
            }
            if (socket != null) {
                socket.close();
                socket = null;
            }
        } catch (Exception e) {
        } //Ignore errors.
    }

} // end of class
