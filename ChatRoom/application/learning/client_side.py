from application import utils
import socket
import threading

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect((utils.IP, utils.PORT))


def send_message():
    while True:
        my_message = str(input("ENTER YOUR MESSAGE : "))
        my_message = f"{len(my_message):<{utils.HEADER_SIZE}}" + my_message
        client_socket.send(my_message.encode('utf-8'))


if __name__ == '__main__':

    thread = threading.Thread(target=send_message)
    thread.start()

    while True:
        message_length = client_socket.recv(utils.HEADER_SIZE).decode('utf-8')

        message_length = int(message_length.strip())
        message = client_socket.recv(message_length).decode('utf-8')

        print(message)
