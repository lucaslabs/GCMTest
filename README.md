GCMTest
=======

Android app to test Google Cloud Messaging (GCM) capabilities to support Push Notifications.

To support Push Notifications we have an Android app as the "Client app" and a NodeJs app as the "Server app".

Features of the "Client app":

1. Register the "Client app" with GCM servers asynchronously.
2. Register the "Client app" in our own "Server app".
3. Use a **IntentService** to process the GCM message.
4. Use a **WakefulBroadcastReceiver** to ensure that the device does not go back to sleep while the **IntentService** is processing the GCM message.
5. Show the received message from the "Server app" as a Notification.

Features of the "Server app":

1. Register the "Server app" with GCM servers asynchronously.
2. Provide an API to register the "Client app".
3. Provide an API to unregister a "Client app" that was registered previously.
4. Provide an API to send a message to the registered "Client app"s.
5. Provide an UI that shows to the user the registered "Client app"s and allows the user to select one or more of the registered "Client app"s to send to it/them a message.

REMEMBER: the "Server app" is a NodeJs app.