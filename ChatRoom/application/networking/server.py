import socket
from PyQt5.QtCore import QThread


# class for checking clents that are connected to the server
class CheckClient(QThread):

    def __init__(self, client: socket.socket, all_clients):
        QThread.__init__(self)
        self.client = client
        self.all_clients = all_clients

    def set_clients_list(self, clients_list):
        self.all_clients = clients_list

    def run(self):
        while True:
            message = self.client.recv(1024)

            print(message)

            for client in self.all_clients:
                client.send(message)


class Server:

    def __init__(self, ip, port, max_connections=10):
        self.ip = ip
        self.port = port
        self.clients = []
        self.max_connections = max_connections

        self.threads = []

        self.server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    def start_server(self):

        self.server_socket.bind((self.ip, self.port))
        self.server_socket.listen(self.max_connections)

        print(f"SERVER ESTABLISHED on {self.ip}:{self.port}")

        while True:
            client_socket, address = self.server_socket.accept()

            self.clients.append(client_socket)

            # append a thread to newly connected client
            check_thread = CheckClient(client_socket, self.clients)
            self.threads.append(check_thread)
            check_thread.start()

            for thread in self.threads:
                thread.set_clients_list(self.clients)

            print(f" {address} CONNECTED ")

            client_socket.send(b'you are connected')
