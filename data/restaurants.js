const ObjectId = require('mongodb').ObjectId;
const mongoCollections = require('../config/mongoCollections');
c
function isCheckStirng(string) {
    if (typeof string !== 'string') throw "error string";
    if (string.trim() === "") throw "error string";
}
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
                throw "wrong phone number3";
            }
        }
    }
}
//slack 特殊字符
function isCheckWeb(web) {
    let len = web.length;
    if (len < 20) throw "wrong web";
    let standStart = "http://www.";
    let standEnd = ".com";
    let web1 = web.slice(0, 11).toLowerCase();
    let web2 = web.slice(11, len - 4);
    let web3 = web.slice(len - 4, len).toLowerCase();
    if (web1 !== standStart) throw "wrong web";
    if (web3 !== standEnd) throw "wrong web";
    for (let i = 0; i < web2.length; i++) {
        if (web2.charAt(i) === " ") throw "wrong web"
    }
}
function isCheckprice(price) {
    let len = price.length;
    if (len < 1 || len > 4) {
        throw "error priceRange";
    }
    for (let i = 0; i < len; i++) {
        if (price.charAt(i) !== '$') throw "error price";
    }
}
//需不需要判断是不是含有特殊字符？
function isCheckCuisines(cuisines) {
    if (!cuisines || !Array.isArray(cuisines)) throw 'You must provide a name for restautant';
    let len = cuisines.length;
    if (len === 0) throw 'You must provide at least one cuisines.';
    cuisines.forEach(element => {
        if(typeof element !== 'string'){
            throw "error cuisines";
        }
        if (element.trim() === "") {
            throw "error cuisines";
        }
    })
}
function isCheckService(service) {
    let len = Object.keys(service).length;
    let keys = Object.keys(service);
    let values = Object.values(service);
    if (len !== 3) throw "error service";
    let standKeys = ['dineIn', 'takeOut', 'delivery'];
    for (let i = 0; i < len; i++) {
        if (keys.indexOf(standKeys[i]) === -1) {
            throw "error service keys";
        }
        if (typeof values[i] !== 'boolean') {
            throw "error service keys";
        }
    }
}
function isCheckId(id) {
    if (typeof id !== 'string' && typeof id !== 'object') {
        throw 'error id, please input right data'
    }
}
module.exports = {
    async create(name, location, phoneNumber, 
        website, priceRange, cuisines, overallRating, serviceOptions) {
        if (arguments.length !== 8) throw "error arguments";
        if (!name) throw 'You must provide a name for restautant';
        if (!location) throw 'You must provide a location for restautant';
        if (!phoneNumber) throw 'You must provide a phoneNumber for restautant';
        if (!website) throw 'You must provide a website for restautant';
        if (!priceRange) throw 'You must provide a priceRange for restautant';
        if (!cuisines || !Array.isArray(cuisines)) throw 'You must provide cuisines for restautant';
        if (cuisines.length === 0) throw 'You must provide at least one cuisine.';
        if (!overallRating) throw 'You must provide an overallRating for restautant';
        if (!serviceOptions || typeof serviceOptions !== 'object') throw 'You must provide serviceOptions for restautant';
        if (overallRating < 0 || overallRating > 5) throw 'error priceRange'
        isCheckStirng(name);
        isCheckStirng(location);
        isCheckStirng(phoneNumber);
        isCheckStirng(website);
        isCheckStirng(priceRange);
        isCheckPhoneNumber(phoneNumber);
        isCheckWeb(website);
        isCheckprice(priceRange);
        isCheckCuisines(cuisines);
        isCheckService(serviceOptions);
        let restautantCollection = await restautans();
        let newRestautant = {
            name: name,
            location: location,
            phoneNumber: phoneNumber,
            website: website,
            priceRange: priceRange,
            cuisines: cuisines,
            overallRating: overallRating,
            serviceOptions: serviceOptions,
           
        };
        const insertInfo = await restautantCollection.insertOne(newRestautant);
        if (insertInfo.insertedCount === 0) throw 'Could not add restautant';
        const newId = insertInfo.insertedId;
        const rest = await this.get(newId);
        return rest;
    },

    async getAll() {
        if (arguments.length !== 0) throw "error getALl";
        let restautansCollection = await restautans();
        let resList = await restautansCollection.find({}).toArray();
        return resList;
    },
    //需要判断id的字节数吗,怎么检查有效ObjecxId
    async get(id) {
        if (arguments.length !== 1) throw "error arguments";
        if (!id) throw "error id";
        const restautansCollection = await restautans();
        isCheckId(id);
        if (typeof id === 'object') {
            id = id.toString();
        }
        const rest = await restautansCollection.findOne({ _id: ObjectId(id) });
        if (rest === null) throw "error id";
        return rest;
    },
    async remove(id) {
        if (arguments.length !== 1) throw "error arguments";
        if (!id) throw "error id";
        const restautansCollection = await restautans();
        isCheckId(id);
        if (typeof id === 'object') {
            id = id.toString();
        }
        const restInfo = await this.get(id);
        const deletionInfo = await restautansCollection.deleteOne({ _id: ObjectId(id) });
        if (deletionInfo.deletedCount === 0) throw "error id";
        return `${restInfo.name} has been successfully deleted!`;
    },
    async rename(id, newWebsite) {
        if (arguments.length !== 2) throw "error arguments";
        if (!id) throw "error id";
        if (!newWebsite) throw 'You must provide a website for restautant';
        isCheckId(id);
        isCheckStirng(newWebsite);
        isCheckWeb(newWebsite);
        if (typeof id === 'object') {
            id = id.toString();
        }
        const restautansCollection = await restautans();
        const updatedInfo = await restautansCollection.updateOne(
            { _id: ObjectId(id) },
            { $set: { website: newWebsite } }
        );
        if (updatedInfo.modifiedCount === 0) {
            throw 'could not update restautant successfully';
        }
        return await this.get(id);
    }
}
