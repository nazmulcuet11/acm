#include<iostream>
#include<string>
#include<map>

using namespace std;

int main()
{
    string s1="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
    string s2="A   3  HIL JM O   2TUVWXY51SE Z  8 ";
    char M[300];
    for(int i=0; i<s1.size(); i++)
        M[s1[i]]=s2[i];
    string str;
    bool palindrome,mirrored;

    while(cin>>str)
    {
        palindrome=mirrored=true;
        int l=str.size();
        for(int i=0; i<=l/2; i++)
        {
            if(str[i]!=str[l-1-i]) palindrome=false;
            if(str[l-1-i]!=M[str[i]]) mirrored=false;
        }
        if(palindrome && mirrored) cout<<str<<" -- is a mirrored palindrome.\n\n";
        else if(palindrome && !mirrored) cout<<str<<" -- is a regular palindrome.\n\n";
        else if(!palindrome && mirrored) cout<<str<<" -- is a mirrored string.\n\n";
        else cout<<str<<" -- is not a palindrome.\n\n";
    }
    return 0;
}
