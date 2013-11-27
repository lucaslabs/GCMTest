var gcm = require('node-gcm');

var sender = new gcm.Sender('AIzaSyC8LGUhFTSUN38CNg0nqSXPrcKbSbMSvEQ');
 
var message = new gcm.Message();

var registrationIds = [];

message.addData('message','GCM Test');
message.delay_while_idle = 1;
 
// At least one token is required - each app will register a different token
registrationIds.push('APA91bGFzZOcGsB37gwEtZOq9GB-xPJ2EoyyAoFsR6qKd1wvs1u8uEn2o7hLgCW4sVaZFJWKth9B2aZhZ_8RctaZXvwiyLdKaJbftPl0zkDqwaPDcNxvO30MkMMmxjavTAA2b5TvfyFQj8oKr9kiBclKSXBhsdG3yrDsq0sV4hjdNsXVZoVKD40');
 
/**
 * Params: message-literal, registrationIds-array, No. of retries, callback-function
 **/
sender.send(message, registrationIds, 4, function (err, result) {
    console.log(result);
});	

/**
 * Without retries
 */
//sender.sendNoRetry(message, registrationIds, function (err, result) {
//    console.log(result);
//});