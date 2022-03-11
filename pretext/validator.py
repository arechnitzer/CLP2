from collections import defaultdict
import lxml.etree as ET
import subprocess

# Hopefully only these paths need setting
pretextPath = "/home/andrew/Projects/pretext/"
# source file
sourceFile = "./clp_2_ic.xml"
# grab the schema-validation xsl
xsltFile = pretextPath + "schema/pretext-validation-plus.xsl"
# jing-scheme
jingScheme = pretextPath + "schema/pretext.rng"
# jing exec
jingExec = "/usr/bin/jing"

# somewhere to put the warnings etc
vlad = defaultdict(list)
jung = defaultdict(list)


# useful functions
def proc_xsl_error(err):
    err_lines = err.split("\n")
    # is ["##..", "PTX: Warn location", "msg0", "msg1",...]
    if len(err_lines) < 2:
        return

    loc = err_lines[1].split("/", 1)[1]
    msg = "\n".join(err_lines[2:])
    vlad[msg].append(loc)


def proc_jing_error(line):
    err_parts = line.split(":", 4)
    # is [file, line, char, error/warning, msg]
    if len(err_parts) < 4:
        return

    jung[err_parts[4]].append([err_parts[0], f"{err_parts[1]}:{err_parts[2]}"])


def do_xsl_validator(src):
    validation_msg = transform(src).__str__()
    print("# validating source via xsl")
    # split and sort the validation messages
    for x in validation_msg.split("\n#"):
        proc_xsl_error(x.strip())

    for msg, loc_list in vlad.items():
        print("v" * 50)
        print(msg)
        for loc in loc_list:
            print(f"\t{loc}")
        print("^" * 50)
    print("# Done with pretext-validation-plus")


def do_jing_validator(src):
    print("# Now running jing")
    jing_result = subprocess.run(
        [jingExec, jingScheme, sourceFile], stdout=subprocess.PIPE
    ).stdout.decode()
    for line in jing_result.split("\n"):
        proc_jing_error(line.strip())
    for msg, loc_list in jung.items():
        print("v" * 50)
        print(msg)
        for fname, loc in loc_list:
            print(f"\t{fname}:{loc}")
        print("^" * 50)
    print("# Done with jing")


if __name__ == "__main__":
    # read in the pretext xslt magic
    xslt = ET.parse(xsltFile)
    # and build the transform
    transform = ET.XSLT(xslt)
    print("# Loaded xsl file and transform")

    # read in the source file
    src = ET.parse(sourceFile)
    # and its xincludes
    try:
        src.xinclude()
    except Exception as err:
        print(">>> ERROR <<< ")
        print(err)
        exit(1)
    print("# Loaded source and its includes")

    do_xsl_validator(src)
    do_jing_validator(src)
