import javalang
import re

def extract_methods(java_code):
    tree = javalang.parse.parse(java_code)
    methods = []
    for path, node in tree:
        if isinstance(node, javalang.tree.MethodDeclaration):
            method_start = node.position.line - 1
            method_end = method_start
            open_braces = 0
            for i, line in enumerate(java_code.splitlines()[method_start:], start=method_start):
                open_braces += line.count('{')
                open_braces -= line.count('}')
                if open_braces == 0 and i > method_start:
                    method_end = i
                    break
            method_content = '\n'.join(java_code.splitlines()[method_start:method_end + 1])
            methods.append((node.name, method_content))
    return methods

def extract_java_method_names(java_code):
    pattern = r'\b(?:public|protected|private|static|void|final|\w+\s+\*?)\s+(\w+)\s*\(.*?(?:\s+throws\s+\w+(?:\s*,\s*\w+)*)?\)?\s*\{'
    method_names = re.findall(pattern, java_code, re.DOTALL)
    return method_names