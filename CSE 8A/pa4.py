def extract_hwk_from_paths (paths) :
    homework_file = []
    for i in paths:
        homework_file.append(i.split('/')[-1])
    
    return homework_file

def find_and_swap (words, word_one, word_two) :
    for i in range(len(words)):
        if words[i] == word_one :
            words[i] = word_two
    return words
