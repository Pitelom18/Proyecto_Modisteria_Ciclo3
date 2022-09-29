const form = document.querySelector('#filtros');

// form.addEventListener('submit', e => {
//     e.preventDefault();
//     const formData = new FormData(e.currentTarget);
//     const request = new XMLHttpRequest();
//     request.open("POST", "/shop");
//     request.send(formData);
// });

const loadProductByFilter = () => {

    console.log("boton funciona");
}

const filtros = async (filtros) => {
    const url = "/api/catalogo/filter";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(filtros),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (filtros.ok) {

    }


}