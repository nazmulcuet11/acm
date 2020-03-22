def word_count_in_lines(words, line_length):
    word_counts = []
    word_cnt, char_cnt, i = 0, 0, 0 
    while i < len(words):
        word_len = len(words[i])
        if char_cnt + word_len <= line_length:
            char_cnt += word_len + 1 # Extra one for space charachter
            word_cnt += 1
            i += 1
        else:
            word_counts.append(word_cnt)
            word_cnt = 0
            char_cnt = 0
    
    if word_cnt > 0:
        word_counts.append(word_cnt)
        
    return word_counts


def solve(words, line_length):
    words_per_line = word_count_in_lines(words, line_length)
    total_line = len(words_per_line)

    lines = []
    start_index = 0
    # Process all but last line
    for i in range(total_line - 1):
        words_count = words_per_line[i]
        
        total_char_in_words = 0
        for j in range(words_count):
            total_char_in_words += len(words[start_index + j])
        
        total_space_needed = line_length - total_char_in_words
        space_per_interval = total_space_needed // (words_count - 1) if words_count > 1 else 0
        extra_space = total_space_needed % (words_count - 1) if words_count > 1 else 0

        line = ''
        first_word = True
        for j in range(words_count):
            word = words[start_index + j]
            if not first_word:
                line += ' ' * space_per_interval
                if extra_space > 0:
                    line += ' '
                    extra_space -= 1
            line += word 
            first_word = False

        # Add extra spces required at the end of last line
        while len(line) < line_length:
            line += ' '

        lines.append(line)
        start_index += words_count

    # Process last line 
    words_count = words_per_line[-1]
    line = ''
    first_word = True
    for j in range(words_count):
        word = words[start_index + j]
        if not first_word:
            line += ' '
        line += word 
        first_word = False
    
    # Add extra spces required at the end of last line
    while len(line) < line_length:
        line += ' '
    
    lines.append(line)
    return lines

class Solution:
    # @param A : list of strings
    # @param B : integer
    # @return a list of strings
    def fullJustify(self, A, B):
        if A == []:
            return ""
        return solve(A, B)

print(Solution().fullJustify([ "" ], 10))