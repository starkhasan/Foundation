def mutate_string(string, position, character):
  l1=list(string)
  l1[position]=character
  s_new=''.join(l1)
  return s_new
  
 if __name__ == '__main__':
    s = raw_input()
    i, c = raw_input().split()
    s_new = mutate_string(s, int(i), c)
    print s_new