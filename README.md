# PushNotification
Demo Android App using FCM and data payload to send a custom Notification with a timer. This works even when the app is in foreground and in background.
Use Google ARC to send notification. Select "POST" method. Request URL "https://fcm.googleapis.com/fcm/send"
header name: "autorization" , header value: "key=YOUR_FCM_SERVER_KEY"
header name: "content-type" , header value: "application/json"

SELECT BODY and type in the below JSON code:
{
  "to": "DEVICE_TOKEN or TOPICS",
  "data": {
    "title": "New Notification!",
    "body": "Test",
    "time": "50000"
  }
}
