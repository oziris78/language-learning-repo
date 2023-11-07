
const bilgiyiYaz = (data) => {
    setTimeout(() => {
        let jsonStr = JSON.stringify(data);
        let jsonObj = JSON.parse(jsonStr);
        const parag = document.getElementById("test");
        let deger = parseFloat(jsonObj["rates"]["TRY"]);
        let newContent = "1 TL " + deger + " EUR değerindedir.";
        parag.innerHTML += newContent + "<br>";
    }, 3000);
};

const getTodos = async () => {
    const res1 = await fetch('https://api.exchangeratesapi.io/latest');
    const data1 = await res1.json();
    return data1;
};

getTodos().then( data => bilgiyiYaz(data) ).catch( err => console.log(err));