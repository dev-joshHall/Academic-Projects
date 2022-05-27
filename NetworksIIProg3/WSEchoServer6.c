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

#define BUFSIZ 50
#define MAXQUEUED 4

// declare any functions located in other .c files here
void DisplayFatalErr(char* errMsg); // writes error message before abnormal termination

void main(int argc, char* argv[])   // argc is # of strings following command, argv[] is array of ptrs to the strings
{
	WSADATA wsaData;                // contains details about WinSock DLL implementation
	
	// Verify correct number of command line arguments, else do the following:
	if (argc != 2) {
		fprintf(stderr, "Error: Supply 2 Command Line Arguments\n");
		exit(1);
	}

	// Initialize Winsock 2.0 DLL. Returns 0 if ok. If this fails, fprint error message to stderr as above & exit(1).  
	int initResult;
	initResult = WSAStartup(MAKEWORD(2, 0), &wsaData);
	if (initResult != 0) {
		printf("WSAStartup failed");
		exit(1);
	}

	int sock;
	char buffer[BUFSIZ];
	struct sockaddr_in6 serverInfo, clientInfo;

	// Create an IPv6 TCP stream socket
	if ((sock = socket(AF_INET6, SOCK_DGRAM, IPPROTO_UDP)) < 0) {
		DisplayFatalErr("socket() function failed.");
	}
	else {
		printf("Socket created successfully.  Press any key to continue...");
		getchar();     // needed to hold console screen open
	}

	memset(&serverInfo, 0, sizeof(serverInfo));
	memset(&clientInfo, 0, sizeof(clientInfo));
	serverInfo.sin6_family = AF_INET6;
	serverInfo.sin6_addr = in6addr_any;
	serverInfo.sin6_port = htons(atoi(argv[1]));

	// Bind socket with server
	if (bind(sock, (const struct sockaddr*) &serverInfo,
		sizeof(serverInfo)) < 0)
	{
		DisplayFatalErr("bind() function failed.");
	}

	printf("JH's IPv6 echo server is ready for client connection...");

	int fromSize;
	int bytesRead;

	fromSize = sizeof(clientInfo);
	for (;;) {
		bytesRead = recvfrom(sock, (char*)buffer, BUFSIZ, 0, (struct sockaddr*) &clientInfo, &fromSize);
		buffer[bytesRead] = '\0';
		printf("Processing the client at %s, client port %c, server port %c", buffer, ntohs(clientInfo.sin6_port), ntohs(serverInfo.sin6_port));
		sendto(sock, (const char*)buffer, strlen(buffer), 0, (const struct sockaddr*)&clientInfo, fromSize);
		printf("\nEcho sent.\n");
	}

	return 0;
}
