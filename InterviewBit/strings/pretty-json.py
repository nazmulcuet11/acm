def pretify(json):
    indent_count = 0
    pretified_json = ''
    already_in_a_new_line = True
    for ch in json:
        if ch == '{' or ch == '[':
            if not already_in_a_new_line:
                pretified_json += '\n'
                pretified_json += '\t' * indent_count
            pretified_json += ch
            pretified_json += '\n'
            indent_count += 1
            pretified_json += '\t' * indent_count
            already_in_a_new_line = True
        elif ch == '}' or ch == ']':
            if not already_in_a_new_line:
                pretified_json += '\n'
            indent_count -= 1
            pretified_json += '\t' * indent_count
            pretified_json += ch
            already_in_a_new_line = False
        elif ch == ',':
            pretified_json += ch
            pretified_json += '\n'
            pretified_json += '\t' * indent_count
            already_in_a_new_line = True
        else:
            pretified_json += ch
            already_in_a_new_line = False
    return pretified_json

class Solution:
    # @param A : string
    # @return a list of strings
    def prettyJSON(self, A):
        pretified_json = pretify(A)
        # print(pretified_json)
        lines = pretified_json.split('\n')
        return lines

# print(Solution().prettyJSON("{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}"))
# print(pretify("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}"))
print(Solution().prettyJSON("[\"foo\",{\"bar\":[\"baz\",null,1.0,2]}]"))




