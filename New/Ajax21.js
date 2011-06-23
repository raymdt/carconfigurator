
var b = -10.312180;
var e = 1.570436;

function move(x){
    var transform = document.getElementById("Camera.001");
    b += parseInt(x)*0.3; // parseFloat not ParseInt
    transform.setAttribute("position", b+" -5.518037 2.737089");
}

function turn(){
    var transform = document.getElementById("t_Camera.001");
    e += 1; // parseFloat not ParseInt
    transform.setAttribute("rotation", "0.748782 -0.393605 -0.533292 "+e);

}