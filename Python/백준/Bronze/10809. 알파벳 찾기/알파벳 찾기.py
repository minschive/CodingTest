S = input()
alphabet = 'abcdefghijklmnopqrstuvwxyz'

for alp in alphabet:
    if alp in S:
        print(S.index(alp), end = ' ')
    else:
        print(-1, end = ' ')