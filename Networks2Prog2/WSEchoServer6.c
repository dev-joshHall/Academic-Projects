// CS 2690 Program 2 
// Simple Windows Sockets Echo Client (IPv6)
// Last update: 3/15/22
// Joshua Hall CS2690-001
// Windows 10 with Visual Studio 2022
//
// Usage: WSEchoClientv6 <server port>
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
#define MAXQUEUED 4

// declare any functions located in other .c files here
void DisplayFatalErr(char* errMsg); // writes error message before abnormal termination

void ProcessClient();

void main(int argc, char* argv[])   // argc is # of strings following command, argv[] is array of ptrs to the strings
{
	// Declare ALL variables and structures for main() HERE, NOT INLINE (including the following...)
	WSADATA wsaData;                // contains details about WinSock DLL implementation
	struct sockaddr_in6 serverInfo;	// standard IPv6 structure that holds server socket info

	// Verify correct number of command line arguments, else do the following:
	if (argc != 2) {
		fprintf(stderr, "Error: Supply 2 Command Line Arguments\n");
		exit(1);
	}

	// Retrieve the command line arguments. (Sanity checks not required, but port and IP addr will need
	// to be converted from char to int.  See slides 11-15 & 12-3 for details.)
	unsigned short serverPort = atoi(argv[1]);

	// Initialize Winsock 2.0 DLL. Returns 0 if ok. If this fails, fprint error message to stderr as above & exit(1).  
	int initResult;
	initResult = WSAStartup(MAKEWORD(2, 0), &wsaData);
	if (initResult != 0) {
		printf("WSAStartup failed");
		exit(1);
	}

	// Create an IPv6 TCP stream socket
	int sock;
	sock = socket(AF_INET6, SOCK_STREAM, IPPROTO_TCP);
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
	serverInfo.sin6_addr = in6addr_any;

	bind(sock, (struct sockaddr*) &serverInfo, sizeof(serverInfo));
	listen(sock, MAXQUEUED);

	printf("JH's IPv6 echo server is ready for client connection...");
	
	char buf[INET6_ADDRSTRLEN];
	int clientSock;
	int clientInfoLen;
	for (;;) {
		struct sockaddr_in6 clientInfo;
		clientInfoLen = sizeof(clientInfo);
		clientSock = accept(sock, (struct sockaddr *) &clientInfo, &clientInfo);
		if (clientSock != -1) {
			printf("Processing the client at %c, client port %c, server port %c", inet_ntop(AF_INET6, &clientInfo.sin6_addr, buf, sizeof(buf)), ntohs(clientInfo.sin6_port), ntohs(serverInfo.sin6_port));
			ProcessClient(clientSock);
		}
	}

	exit(0);
}
