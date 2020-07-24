from application.networking.server import Server
from application import utils

if __name__ == '__main__':
    server = Server(utils.IP, utils.PORT)

    server.start_server()
