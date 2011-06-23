		function changeView(){
                var transform = document.getElementsByTagName("xml3d");
                //alert(transform[0].style);
                var activView = transform[0].activeView;
                if(activView == "#Camera.001"){
                  transform[0].setAttribute("activeView", "#Camera");
                }
                
                if(activView == "#Camera"){
                        transform[0].setAttribute("activeView", "#Camera.001");
                }
            }
