/**
Write a simple javascript program to implement a travel website work flow using promises.

Steps:

- First page: show flight booking page
- Second page: show hotel booking page
- Third page: show car booking page

Error flows: 
 - If the first page errors show a page saying your flight booking failed.
 - If the second page errors show a page saying your hotel booking failed.
 - If the third page errors show a page saying your car booking failed.
*/
var rp = require('request-promise');

rp('http://www.googleasdfs.com')
.then((htmlString) => {
    console.log(htmlString);
}).then((
    ).catch((err) => {
    console.log("ERROR: no doing kaaki behavior"); console.log(err);
})
 
// 
// var promise = new Promise((resolve, reject) => {
// 
// }).then((responseFromFlightBooking) => {
// 
// 
// }).then((responseFromHotelBooking) => {
// 
// }).catch((err) => {
// // })
