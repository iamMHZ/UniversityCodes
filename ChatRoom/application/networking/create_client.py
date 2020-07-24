from application.networking.client import Client
from application import utils

if __name__ == '__main__':
    username = input("ENTER A username : ")

    client = Client(utils.IP, utils.PORT, username)
    client.connect_to_server()
