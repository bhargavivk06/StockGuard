import threading
import requests

URL = "http://localhost:8080/orders?productId=1&quantity=1"
THREADS = 50

def place_order():
    response = requests.post(URL)
    print(response.status_code, response.text)

threads = []
for i in range(THREADS):
    t = threading.Thread(target=place_order)
    threads.append(t)

for t in threads:
    t.start()

for t in threads:
    t.join()

print("Done!")