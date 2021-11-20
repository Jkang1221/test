const restautans = require('./data/restaurants');
const connection = require('./config/mongoConnection');

const main = async () => {
    //1 2
    try {
        var newRest1 = await restautans.create("The Saffron Lounge", "New York City, New York", "123-456-7890",
            "http://www.saffronlounge.com", "$$$$", ["Cuban", "Italian"], 3, { dineIn: true, takeOut: true, delivery: false });
        console.log(newRest1);
        console.log("create restautant successfully");
    } catch (e) {
        console.log("create restautant error")
    }
    //3
    try {
        var newRest2 = await restautans.create("The PHO", "Jersey City, New Jersey", "789-412-6120",
            "http://www.Jikang.COM", "$$", ["Chinese"], 5, { dineIn: false, takeOut: true, delivery: false });
        console.log("create restautant successfully");
    } catch (e) {
        console.log("create restautant error")
    }
    //4
    try {
        const all = await restautans.getAll();
        console.log(all);
        console.log("get all restautant successfully");
    } catch (e) {
        console.log("get all restautant error")
    }
    //5  6
    try {
        var newRest3 = await restautans.create("The Den ton", "Jersey City, New Jersey", "456-123-7777",
            "http://www.japanese.COM", "$", ["Japanese"], 5, { dineIn: false, takeOut: true, delivery: false });
        console.log(newRest3);
        console.log("create restautant successfully");
    } catch (e) {
        console.log("create restautant error")
    }
    //7   8
    try {
        var newWebRest = await restautans.rename(newRest1._id, "http://www.Jiakangliang.com");
        console.log(newWebRest);
        console.log("rename restautant successfully");
    } catch (e) {
        console.log("rename restautant error")
    }
    //9 
    try {
        const deleteID = await restautans.remove(newRest2._id);
        console.log(deleteID);
        console.log("delete restautant successfully");
    } catch (e) {
        console.log("delete restautant error")
    }
    //10
    try {
        const all2 = await restautans.getAll();
        console.log(all2);
        console.log("get all restautant successfully");
    } catch (e) {
        console.log("get all restautant error")
    }
    //11
    try {
        const newRest4 = await restautans.create("The Saffron Lounge", "New York City, New York", "123-456-7890",
            "http://www.saffron lounge.com", "$$$$", ["Cuban", "Italian"], 3, { dineIn: true, takeOut: true, delivery: false });
        console.log("create restautant successfully");
    } catch (e) {
        console.log("create restautant error")
    }
    //12
    try {
        const deleteRest = await restautans.remove("615f5b786b72d4aa2fd090e5");
        console.log(deleteRest);
        console.log("delete restautant successfully");
    } catch (e) {
        console.log("delete restautant error")
    }
    //13
    try {
        const deleteRest = await restautans.rename("615f5b786b72d4aa2fd090e6", "http://www.Jiakangliang.com");
        console.log("rename restautant successfully");
    } catch (e) {
        console.log("rename restautant error")
    }
    //14
    try {
        const deleteRest = await restautans.rename("", "http://www.Jiakangliang.com");
        console.log("rename restautant successfully");
    } catch (e) {
        console.log("rename restautant error")
    }
    //15
    try {
        const deleteRest = await restautans.get("");
        console.log("get restautant successfully");
    } catch (e) {
        console.log("get restautant error")
    }
    const db = await connection();
    await db.serverConfig.close();
    console.log('Done!');
}
main().catch((error) => {
    console.log(error);
});