const addToCart = (productoid) => {
    let userInfo = localStorage.getItem("loggedUser");
    if (userInfo == undefined) {
        userInfo = new Map();
        // console.log("no hay usuario");
    } else {
        // console.log("hay usuario");
        userInfo = new Map(Object.entries(JSON.parse(userInfo)));
    }
    // console.log(productoid);
    // console.log(userInfo.get('carro'));
    carro = userInfo.get('carro');
    if (productoid in userInfo.get('carro')) {
        // console.log("si esta");
        carro[productoid] += 1;
        // console.log(carro);
    } else {
        // console.log("No esta");
        carro[productoid] = 1;
        // console.log(carro);
    }

    userInfo.set('carro', carro);
    // console.log(userInfo);
    // console.log(userInfo.get('carro'));


    localStorage.setItem("loggedUser", JSON.stringify(Object.fromEntries(userInfo)));
    updateCart();
}



const formatter = new Intl.NumberFormat('en-US');

const loadCartDetails = () => {

    console.log("metodo loadcartdetails");

    let items = localStorage.getItem("loggedUser");
    if (items == undefined) {
        console.log("no usuario");
        return;
    }

    const totalElem = document.getElementById("total");
    let total = 0;
    let detail = document.getElementById("detail");
    detail.innerText = "";
    items = new Map(Object.entries(JSON.parse(items))).get('carro');
    
    
    Object.entries(items)
        .forEach(async ([id, quantity]) => {

            let response = await fetch('/api/producto/' + id);
            let producto = await response.json();
            
            const totalPrice = producto.precio * quantity;
            total += totalPrice;

            let item2 = [
                `<tr id="producto-${producto.id}">`,
                `   <td class="align-middle"><img src=${producto.imageUrl} alt="" style="width: 50px;"> ${producto.nombre}</td>`,
                `   <td class="align-middle" id="price-${id}">$${formatter.format(parseFloat(producto.precio))}</td>`,
                `   <td class="align-middle">`,
                `   <div class="input-group quantity mx-auto" style="width: 100px;">`,
                `       <div class="input-group-btn">`,
                `           <button class="btn btn-sm btn-primary btn-minus" >`,
                `               <i class="fa fa-minus"></i>`,
                `           </button>`,
                `       </div>`,
                `       <input type="text" id="item-${id}" value="${quantity}" class="form-control form-control-sm bg-secondary text-center" >`,
                `       <div class="input-group-btn">`,
                `           <button class="btn btn-sm btn-primary btn-plus">`,
                `               <i class="fa fa-plus"></i>`,
                `           </button>`,
                `       </div>`,
                `   </div>`,
                `</td>`,
                `<td class="align-middle" id="total-${id}">$${formatter.format(parseFloat(totalPrice))}</td>`,
                `<td class="align-middle"><button onclick="removeItem('${id}')" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button></td>`,
                ` </tr>`
            ].join('\n')

            detail.innerHTML = detail.innerHTML + item2;
            totalElem.innerText = formatter.format(total);
        });
};

const updateTotalItem = (key) => {
    const totalElem = document.getElementById("total");

    let totalItemElem = document.getElementById("total-" + key);
    let itemValue = document.getElementById("item-" + key).value;
    let priceValue = document.getElementById("price-" + key).innerText;

    let total = parseIntlNumber(totalElem.innerText, 'en-US') - parseIntlNumber(totalItemElem.innerText, 'en-US');

    totalItemElem.innerText = formatter.format(parseIntlNumber(itemValue, 'en-US') * parseIntlNumber(priceValue, 'en-US'));
    total += parseIntlNumber(totalItemElem.innerText, 'en-US');

    totalElem.innerText = formatter.format(total);
};

const parseIntlNumber = (stringNumber, locale) => {
    var thousandSeparator = Intl.NumberFormat(locale).format(11111).replace(/\p{Number}/gu, '');
    var decimalSeparator = Intl.NumberFormat(locale).format(1.1).replace(/\p{Number}/gu, '');

    return parseInt(stringNumber
        .replace(new RegExp('\\' + thousandSeparator, 'g'), '')
        .replace(new RegExp('\\' + decimalSeparator), '.')
    );
};

const removeItem = (key) => {
    let userInfo = localStorage.getItem("loggedUser");
    userInfo = new Map(Object.entries(JSON.parse(userInfo)));
    
    carro = userInfo.get('carro');
    delete carro[key];
    userInfo.set('carro', carro);
    localStorage.setItem("loggedUser", JSON.stringify(Object.fromEntries(userInfo)));

    const totalItemValue = parseIntlNumber(document.getElementById("total-" + key).innerText, 'en-US');
    console.log(totalItemValue);
    const totalElem = document.getElementById("total");

    totalElem.innerText = formatter.format(parseIntlNumber(totalElem.innerText, 'en-US') - totalItemValue);

    const movieElm = document.getElementById("producto-" + key);
    movieElm.remove();
}