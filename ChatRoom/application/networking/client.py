import socket
import time
import threading


class Client:

    def __init__(self, server_ip, server_port, username):
        self.server_ip = server_ip
        self.server_port = server_port
        self.username = username
        self.client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    def connect_to_server(self):

        self.client_socket.connect((self.server_ip, self.server_port))

        # getting input for ever
        thread = threading.Thread(target=self.read_console)
        thread.start()

        while True:
            message = self.client_socket.recv(1024)

            print(message.decode('utf-8'))

    def read_console(self):
        while True:
            data = input("")
            data = self.username + " : " + data
            data = data.encode("utf-8")

            self.client_socket.send(data)
