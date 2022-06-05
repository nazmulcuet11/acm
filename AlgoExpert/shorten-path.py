def shortenPath(path):
    def solveAbsolutePath(comps):
        stk = []
        for i in range(len(comps)):
            comp = comps[i]
            if comp == '' or comp == '.':
                continue
            elif comp == '..':
                if len(stk) > 0:
                    stk.pop()
            else:
                stk.append(comp)

        return '/' + '/'.join(stk)

    def solveRelativePath(comps):
        stk = []
        for i in range(len(comps)):
            comp = comps[i]
            if comp == '' or comp == '.':
                continue
            elif comp == '..':
                if len(stk) > 0 and stk[-1] != '..':
                    stk.pop()
                else:
                    stk.append(comp)
            else:
                stk.append(comp)

        return '/'.join(stk)

    comps = path.split("/")

    if comps[0] == '':  # absolute path
        return solveAbsolutePath(comps)
    else:  # relative path
        return solveRelativePath(comps)
