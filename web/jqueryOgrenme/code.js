
$(function(){

    const btn = $('#btn');
    const parag1 = $('#parag1');
    
    

    btn.click(() => {
        let curSize = parag1.css('font-size');
        curSize = parseInt(curSize.substr(0,2));
        if(curSize > 95) {
            parag1.animate({"font-size": "-=50px"}, 200);
        }
        else {
            parag1.animate({"font-size": "+=10px"}, 200);
        }
    });



});