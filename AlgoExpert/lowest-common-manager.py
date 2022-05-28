def getLowestCommonManager(topManager, reportOne, reportTwo):
    def find(node):
        if not node:
            return (None, [])

        allReports = []
        for report in node.directReports:
            ans, reports = find(report)
            if ans:
                return (ans, [])
            allReports += reports

        if node == reportOne or node == reportTwo:
            allReports.append(node)

        found = 0
        for report in allReports:
            if report == reportOne or report == reportTwo:
                found += 1

        if found == 2:
            return (node, [])

        return (None, allReports)

    return find(topManager)[0]


# This is an input class. Do not edit.
class OrgChart:
    def __init__(self, name):
        self.name = name
        self.directReports = []
