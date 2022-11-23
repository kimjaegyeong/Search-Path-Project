            function gathering() {
              
                var submitButton = document.submitButton;    

				var arr =new Array(25);
				var number_arr = [];
				for(var i=0; i<25; i++){
					var number ="number"+i;
					number_arr[i]= number;
					
				}
				
				
				for(var j=0; j<25; j++){
					//arr[j] = submitButton.number_arr[j].value;
					//submitButton.(이 곳에는 html 자체로 하드코딩 된 name을 써야함. 변수 참조 불가능).value;
					arr[j]= submitButton[number_arr[j]+""].value;
					
					//alert(arr[j]);
				}
							
				/* // 서블릿으로 전송
                    submitButton.method = "post";
                    submitButton.action = "login";
                    submitButton.submit();   
                */
            }
