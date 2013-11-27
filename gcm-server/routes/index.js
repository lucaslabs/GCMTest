
var gcm = require('node-gcm'),
  _ = require('underscore'),
  // Registration IDs of devices IDs are stored in memory
  registrationIds = [], 
  sender = new gcm.Sender('AIzaSyC8LGUhFTSUN38CNg0nqSXPrcKbSbMSvEQ'),
  dialog = require('dialog');
/*
 * GET home page.
 */ 
exports.index = function(req, res) {
  console.log("@ Index");
  
  console.log(sender);
  
  res.render('index', {
   title: 'GCM Server',
   receptors: registrationIds
  });
};

/*
 * GET register page.
 */
exports.register = function(req, res) {
  console.log("@ Register");  
  
  console.log("Request body: " + JSON.stringify(req.body));  
  console.log("\n");  
  console.log("Request body.regId: " + JSON.stringify(req.body.regId));
  
  // Add the incoming registration ID
  registrationIds.push(req.body.regId);
  
  console.log("Registration IDs count: " + registrationIds.length);
  
  res.send(200);
};

/*
 * GET unregister page.
 */ 
exports.unregister = function(req, res) {
  console.log("@ Unregister");
  registrationIds = _.without(registrationIds, req.body.regId);
  res.send(200);
};
 
/*
 * POST message page.
 */
exports.send_message = function(req, res) {
  console.log("@ Send Message");

  console.log("Request body: " + JSON.stringify(req.body)); 
  
  var message = new gcm.Message();
  message.addData('message', req.body.message);
  message.delay_while_idle = 1;
    
  _.intersection(registrationIds, req.body.receptors.split(','));
  
/**
 * Params: message-literal, registrationIds-array, No. of retries, callback-function
 **/
  sender.send(message, registrationIds, 4, function (error, result) {
	if(result != null) {
	  dialog.info("Message sent");
	  console.log("Message sent!");
	} else {
	  dialog.warn("Error sending message: " + error);	
	  console.log("Error sending message: " + error);      
	}
  });	

/**
 * Without retries
 */
//sender.sendNoRetry(message, registrationIds, function (error, result) {
//    console.log(result);
//});
  
  res.redirect('/');
};