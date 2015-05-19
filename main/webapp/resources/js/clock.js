$(document).ready(function(){
    setTimeout(updateTime, 1000);
})

function updateTime() {
    var d = new Date();
    $('#clock').text(d.getHours()+':'+ d.getMinutes()+':'+((d.getSeconds()<10)?('0'+d.getSeconds()): d.getSeconds()));
    setTimeout(updateTime, 1000);
}