
const bilgiGeldi = (jsonObj) => {
    setTimeout(()=>{
        let jsonStr = JSON.parse(jsonObj);
        const parag = document.getElementById("test");
        let deger = parseFloat(jsonStr["rates"]["TRY"]);
        let newContent = "1 TL " + deger + " EUR değerindedir.";
        parag.innerHTML += newContent + "<br>";
    }, 2000);   
};

const bilgiGelmedi = (status) => {
    if(status === 4){
        alert("başarısız.......");
    }
};

const bilgiEldeEt = (url) => {
    const req = new XMLHttpRequest();

    req.addEventListener('readystatechange', () => {
        if(req.readyState === 4 && req.status === 200){
            return bilgiGeldi(req.responseText);
        }
        else{
            return bilgiGelmedi(req.status, "an error occured");
        }
    });

    req.open('GET', url);
    req.send();
};

bilgiEldeEt('https://api.exchangeratesapi.io/latest');
bilgiEldeEt('https://api.exchangeratesapi.io/latest');
bilgiEldeEt('https://api.exchangeratesapi.io/latest');

