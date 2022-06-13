(function($) { 
	$(function() {
		$(".menu-ul").clone().appendTo(".gnb-depwr");
		$(".hambtn").click(function(){
			var chk = $(".menu-wrap").css("display");
			if(chk == "none"){
				$(".hambtn").addClass("active");
				$(".menu-ham .menu-wrap").show();
				setTimeout(function(){
					$(".menu-ham .menu-wrap").addClass("active");
				},500);
				setTimeout(function(){
				},1500)

			}else{
				$(".hambtn").removeClass("active");
				$(".menu-ham .menu-ul > li").removeClass("active");
				$(".menu-ham .menu-wrap").addClass("active-end");
				setTimeout(function(){
					$(".menu-ham .menu-wrap").removeClass("active");
					$(".menu-ham .menu-wrap").hide();
					$(".menu-ham .menu-wrap").removeClass("active-end");
					$(".menu-ham .menu-ul > li").find(".dep02").hide();
				},1000);
			}
		})
		$(".acad-btn").click(function(){
			var chk = $(".myaca-wrap").css("display");
			$(".myaca-wrap").show();
			setTimeout(function(){
				$(".myaca-wrap").addClass("active");
				//$(".menu-ul > li").eq(0).find(".dep02").slideToggle();
			},500);
		})
		$(".aca-clo").click(function(){
			$(".myaca-wrap").removeClass("active");
			setTimeout(function(){
				$(".myaca-wrap").hide();
			},1000);
		})
		$(".search-box").not(".disable").each(function(){
			var btn = $(this).find("p");
			var ul = $(this).find(".sear-ul");
			btn.click(function(){
				var chk = ul.css("display");
				if(chk == "none"){
					$(".search-box .on").removeClass("on");
					$(".sear-ul").hide();
					btn.addClass("on");
				}else{
					btn.removeClass("on");
				}
				ul.slideToggle();
			})
			$(".main-sec").click(function(){
				$(".search-box .on").removeClass("on");
				$(".sear-ul").hide();
			})
		})

		$(".family-tit").click(function(){
			var chk = $(".fam-ul").css("display");
			if(chk == "none"){
				$(".family-tit").addClass("on");
			}else{
				$(".family-tit").removeClass("on");
			}
			$(".fam-ul").slideToggle();
		})

	}); 


	$(function(){
		
		$(".menu-ham .menu-ul > li").click(function(){
			$(".menu-ham .menu-ul > li").removeClass("active");
			$(this).addClass("active");
			$(".menu-ham .menu-ul > li .dep02").hide("slide");
			$(this).find(".dep02").slideToggle();
		})

		$(".menu-img").each(function(){
			var img = $(this).find("img").attr("src");
			$(this).css("background-image","url("+img+")");
		
		});

		$(".main-slide").find(".msli-p").click(function(){
			var chk = $(".main-slide .msli-sns ul").css("display");
			if(chk == "none"){
				$(".main-slide .msli-sns ul").show();
				$(".main-slide .swiper-pagination-bullet").hide();
				setTimeout(function(){
					$(".main-slide .msli-sns ul").hide();
					$(".main-slide .swiper-pagination-bullet").show();
				},5000)
			}else{
				$(".main-slide .msli-sns ul").hide();
				$(".main-slide .swiper-pagination-bullet").show();
			}
		})
	});

	$(function(){
		$(".lnb-ul li").each(function(){
			var $this = $(this);
				href = $this.find("a").attr("href");
				path = location.pathname;
			var x = $(this).offset().left;
			
			if(href==path){
				$this.addClass("active");
				$this.parents("li").addClass("active");
				$('.lnb-ulwr').scrollLeft(x-20);
			}

		})
	})
	$(function(){
		$(".edit-bg, .close-btn").click(function(){
			$(".edit-popup").fadeOut(200);
		})
	

	})

	$(function(){
		$(".nav-ul01 > li").not(".not-li").each(function(){
			var $this = $(this);
			var ind = $this.index();
			var depth = $(".gnb-depth .menu-ul > li");
			
			$this.mouseenter(function(){
				$(".nav-ul01 > li").removeClass("on");
				depth.hide();
				$(this).addClass("on");
				depth.eq(ind).show();
				$(".gnb-depth").show();

			});
			$(".gnb-depth").mouseleave(function(){
				$(".nav-ul01 > li").removeClass("on");
				depth.hide();
				$(".gnb-depth").hide();

			});

			

		})
	})
	
	



	
} ) ( jQuery);