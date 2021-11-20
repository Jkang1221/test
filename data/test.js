function isCheckPhoneNumber(num) {
    let len = num.length;
    if (len !== 12) throw "wrong phone number1";
    for (let i = 0; i < len; i++) {
        if (i === 3 || i === 7) {
            if (num.charAt(i) !== '-') {
                throw "wrong phone number2";
            }
        } else {
            //console.log(num.charAt(i)<6);
            if (num.charAt(i) <= 9 && num.charAt(i) >= 0) {
                continue;
            } else {
                console.log(num.charAt(i))
                throw "wrong phone number3";
            }
        }
    }
}
let num = "123-456-7890";
//isCheckPhoneNumber(num)
function isCheckWeb(web) {
    let len = web.length;
    //console.log(len);
    //if(len<20) throw "wrong web";
    let standStart = "http://www.";
    let standEnd = ".com";
    let web1 = web.slice(0, 11);
    let web2 = web.slice(11, len - 4);
    let web3 = web.slice(len - 4, len);
    if (web1 !== standStart) throw "error";
    if (web3 !== standEnd) throw "error";
    for (let i = 0; i < web2.length; i++) {
        if (web2.charAt(i) === " ") throw "error"
    }
}
let web = "http://www.sds a.com";
//isCheckWeb(web);
function isCheckprice(price) {
    let len = price.length;
    if (len < 1 || len > 4) {
        throw "error priceRange";
    }
    for (let i = 0; i < len; i++) {
        if (price.charAt(i) !== '$') throw "error price";
    }
}
let price = '$$'
//isCheckprice(price)
function isCheckCuisines(cuisines) {
    if (!cuisines || !Array.isArray(cuisines)) throw 'You must provide a name for restautant';
    let len = cuisines.length;
    if (len === 0) throw 'You must provide at least one cuisines.';
    let flag = 0;
    cuisines.forEach(element => {
        if (element.trim() == "") {
            flag++;
        }

    })
    if (flag === len) throw "error";
}
let cuisines = ["", "   "];
//isCheckCuisines(cuisines);
function isCheckService(service) {
    let len = Object.keys(service).length;
    let keys = Object.keys(service);
    let values = Object.values(service);
    if (len !== 3) throw "error service";
    let standKeys = ['dineIn', 'takeOut', 'delivery'];
    for (let i = 0; i < len; i++) {
        if (standKeys.indexOf(keys[i]) === -1) {
            throw "error";
        }
        if (typeof values[i] !== 'boolean') {
            throw "error"
        }
    }
}
let ser = { dineIn: true, takeOut: true, delivery: false };
//isCheckService(ser);
//console.log(id)
let keys = ['dineIn','dineIn', 'takeOut', 'as'];

let len =3;
let standKeys = ['dineIn', 'takeOut', 'delivery'];
for (let i = 0; i < 4; i++) {
    // if (keys.indexOf(standKeys[i]) === -1) {
    //     throw "error service keys";
    // }
    console.log(keys.indexOf(standKeys[i]))
}