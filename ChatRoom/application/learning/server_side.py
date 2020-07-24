from application import utils
import socket
import select
import threading

clients = []


def receive_message(client_socket):
    message_length = client_socket.recv(utils.HEADER_SIZE).decode('utf-8')

    message_length = int(message_length.strip())
    message = client_socket.recv(message_length).decode('utf-8')

    print(f"{client_socket} > {message}")


def add_client(client_socket):
    clients.append(client_socket)
    print(f"\nNUMBER OF CLIENTS : {len(clients)} \n")


def check_clients():
    while True:

        for client in clients:
            receive_message(client)


def main():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((utils.IP, utils.PORT))

    server_socket.listen(10)

    print(f"SERVER STABILISED IP: {utils.IP} PORT: {utils.PORT}")

    thread = threading.Thread(target=check_clients)
    thread.start()

    while True:
        client_socket, address = server_socket.accept()

        print(f"Connection from {address} Established  ")

        add_client(client_socket)

        message = "WELCOME to the server"
        # combining messages with headers so they won't exceed the client buffer
        message = f"{len(message):<{utils.HEADER_SIZE}}" + message
        # print(message)

        client_socket.send(message.encode('utf-8'))


if __name__ == '__main__':
    main()
