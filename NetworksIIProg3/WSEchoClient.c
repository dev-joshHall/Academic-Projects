// CS 2690 Program 3
// Simple Windows Sockets Echo Client (IPv6)
// Joshua Hall CS2690-001 3-22-2022
// Windows 10 with Visual Studio 2022
//
// Usage: WSEchoClientv6 <server IPv6 address> <server port> <"message to echo">
// Companion server is WSEchoServerv6
// Server usage: WSEchoServerv6 5000
//
// This program is coded in conventional C programming style, with the 
// exception of the C++ style comments.
//
// I declare that the following source code was written by me or provided
// by the instructor. I understand that copying source code from any other 
// source or posting solutions to programming assignments (code) on public
// Internet sites constitutes cheating, and that I will receive a zero 
// on this project if I violate this policy.
// ----------------------------------------------------------------------------

// Minimum required header files for C Winsock program
#include <stdio.h>       // for print functions
#include <stdlib.h>      // for exit() 
#include <winsock2.h>	 // for Winsock2 functions
#include <ws2tcpip.h>    // adds support for getaddrinfo & getnameinfo for v4+6 name resolution
#include <Ws2ipdef.h>    // optional - needed for MS IP Helper
#include "WSEchoClient6.h"

#define RCVBUFSIZ 50
#define LRGBUFSIZ 1000

// declare any functions located in other .c files here
void DisplayFatalErr(char* errMsg); // writes error message before abnormal termination

void main(int argc, char* argv[])   // argc is # of strings following command, argv[] is array of ptrs to the strings
{
	// Declare ALL variables and structures for main() HERE, NOT INLINE (including the following...)
	WSADATA wsaData;                // contains details about WinSock DLL implementation
	struct sockaddr_in6 serverInfo;	// standard IPv6 structure that holds server socket info

	// Verify correct number of command line arguments, else do the following:
	if (argc != 4) {
		fprintf(stderr, "Error: Supply 3 Command Line Arguments\n");
		exit(1);
	}

	// Retrieve the command line arguments. (Sanity checks not required, but port and IP addr will need
	// to be converted from char to int.  See slides 11-15 & 12-3 for details.)
	char* serverIPaddr = argv[1];
	char* phrase = argv[3];
	unsigned short serverPort = atoi(argv[2]);

	// Initialize Winsock 2.0 DLL. Returns 0 if ok. If this fails, fprint error message to stderr as above & exit(1).  
	int initResult;
	initResult = WSAStartup(MAKEWORD(2, 0), &wsaData);
	if (initResult != 0) {
		printf("WSAStartup failed");
		exit(1);
	}

	// Create an IPv6 TCP stream socket
	int sock;
	sock = socket(AF_INET6, SOCK_DGRAM, IPPROTO_UDP);
	if (sock < 0) {
		DisplayFatalErr("socket() function failed.");
	}
	else {
		printf("Socket created successfully.  Press any key to continue...");
		getchar();     // needed to hold console screen open
	}

	// Zero out the sockaddr_in6 structure and load server info into it.
	memset(&serverInfo, 0, sizeof(serverInfo));
	serverInfo.sin6_family = AF_INET6;
	serverInfo.sin6_port = htons(serverPort);
	inet_pton(AF_INET6, serverIPaddr, &serverInfo.sin6_addr);


	// Send message to server (without '\0' null terminator). Check for null msg (length=0) & verify all bytes were sent
	if (sendto(sock, phrase, sizeof(phrase), 0, (struct sockaddr *) &serverInfo, sizeof(serverInfo)) != sizeof(phrase)) {
		DisplayFatalErr("sendto() function failed.");
	}

	// Retrieve the message returned by server.
	// Manage receive buffer to prevent overflow with a big message.
	int fromSize = sizeof(serverInfo);

	if (strlen(phrase) < RCVBUFSIZ) {
		char rcvBuffer[RCVBUFSIZ];
		int bytesRead;
		if (bytesRead = recvfrom(sock, (char*)rcvBuffer, RCVBUFSIZ, 0, (struct sockaddr*) &serverInfo, &fromSize) <= 0) {
			DisplayFatalErr("recvfrom() function failed");
		}
		rcvBuffer[bytesRead] = "\0";
		// Display ALL of the received message, in printable C string format.
		printf("\nMessage received: %.*s", strlen(phrase), rcvBuffer);
	}
	else {
		char rcvBuffer[LRGBUFSIZ];
		int bytesRead;
		if (bytesRead = recvfrom(sock, (char*)rcvBuffer, LRGBUFSIZ, 0, (struct sockaddr*) &serverInfo, &fromSize) <= 0) {
			DisplayFatalErr("recvfrom() function failed");
		}
		rcvBuffer[bytesRead] = "\0";
		// Display ALL of the received message, in printable C string format.
		printf("\nMessage received: %.*s", strlen(phrase), rcvBuffer);
	}

	// Close the TCP connection (send a FIN)
	closesocket(sock);

	// Release the Winsock DLL
	WSACleanup();

	exit(0);
}
