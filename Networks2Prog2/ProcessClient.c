// Last update: 3/15/22
// Joshua Hall CS2690-001
// Windows 10 with Visual Studio 2022
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

#define LRGBUFSIZ 1000

// declare any functions located in other .c files here
void DisplayFatalErr(char* errMsg); // writes error message before abnormal termination

void ProcessClient(int sock)
{
	char rcvBuffer[LRGBUFSIZ];
	int bytesRead;
	if ((bytesRead = recv(sock, rcvBuffer, LRGBUFSIZ - 1, 0)) <= 0) {
		DisplayFatalErr("\nrecv() function failed.");
	}
	printf("\nMessage received: %.*s", strlen(rcvBuffer), rcvBuffer);
	if (strlen(rcvBuffer) == 0) {
		DisplayFatalErr("\nCould not send message of 0 length.");
	}
	if (send(sock, rcvBuffer, strlen(rcvBuffer), 0) != strlen(rcvBuffer)) {
		DisplayFatalErr("\nsend() function failed.");
	}
	closesocket(sock);
}
