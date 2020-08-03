import os

def readTestcase():
    content = ""
    with open("testcase.csv") as file:
        content = file.read()
    return content

def writeTestcase(content):
    with open("testcase.csv", "w") as file:
        file.write(content)

jar = "jar\\"
testcase = readTestcase()
os.system("find . -name '.DS_Store' -type f -delete")
# os.system("rm -rf out/*")
# os.system("rm -rf lab/*")
for iid in os.listdir(jar):
    iid = iid.replace(".jar", "")
    idd = jar + iid
    java = "java -jar "
    lab_strs = [
        java + "LAB1.jar 1 -r testcase.csv -s lab\lab1_0.csv",
        java + "LAB1.jar 1 -r testcase.csv -g inbimfgw@gmail.com > lab/lab1_1.csv",
        java + "LAB1.jar 1 -r testcase.csv -s lab/lab1_2.csv -a ack@gmail.com 979517",
        java + "LAB1.jar 1 -r testcase.csv -s lab/lab1_3.csv -d rpxgg@gmail.com",
        java + "LAB1.jar 1 -r testcase.csv -s lab/lab1_4.csv -u jgsornk@gmail.com 999999",
        java + "LAB1.jar 1 -r testcase.csv -s lab/lab1_5.csv -dt",
        java + "LAB1.jar 1 -r testcase.csv -t > lab/lab1_6.csv",
        java + "LAB1.jar -h > lab/lab1_7.csv",
        java + "LAB1.jar 2 https://www.journaldev.com/629/java-catch-multiple-exceptions-rethrow-exception lab/lab1_8.csv",
        java + "LAB1.jar 2 https://autotouch.net lab/lab1_9.csv",
        java + "LAB1.jar 2 https://www.w3schools.com lab/lab1_10.csv",
        java + "LAB1.jar 2 https://www.wikipedia.org lab/lab1_11.csv"
    ]

    for lab_str in lab_strs:
        os.system(lab_str)

    exec_strs = [
        java + idd +".jar 1 -r testcase.csv -s out/out1_0.csv > .tmp",
        java + idd +".jar 1 -r testcase.csv -g inbimfgw@gmail.com > out/out1_1.csv",
        java + idd +".jar 1 -r testcase.csv -s out/out1_2.csv -a ack@gmail.com 979517 > .tmp",
        java + idd +".jar 1 -r testcase.csv -s out/out1_3.csv -d rpxgg@gmail.com > .tmp",
        java + idd +".jar 1 -r testcase.csv -s out/out1_4.csv -u jgsornk@gmail.com 999999 > .tmp",
        java + idd +".jar 1 -r testcase.csv -s out/out1_5.csv -dt > .tmp",
        java + idd +".jar 1 -r testcase.csv -t > out/out1_6.csv",
        java + idd +".jar -h > out/out1_7.csv",
        java + idd +".jar 2 https://www.journaldev.com/629/java-catch-multiple-exceptions-rethrow-exception out/out1_8.csv > .tmp",
        java + idd +".jar 2 https://autotouch.net out/out1_9.csv > .tmp",
        java + idd +".jar 2 https://www.w3schools.com out/out1_10.csv > .tmp",
        java + idd +".jar 2 https://www.wikipedia.org out/out1_11.csv > .tmp"
    ]

    your_point = 0
    for index, exec_str in enumerate(exec_strs):
        print(exec_strs[index])
        os.system(exec_str)
        os.system("rm .tmp")
        if testcase != readTestcase():
            writeTestcase(testcase)
        filename = "out/out1_" + str(index) + ".csv"
        if os.path.isfile(filename):
            with open(filename) as output:
                content = output.readlines()
                if index == 0:
                    try:
                        with open("lab/lab1_" + str(index) + ".csv") as basefile:
                            base_content = basefile.readlines()
                            flag = True
                            for i, line in enumerate(base_content):
                                base_rows = line.strip().split(",")
                                rows = content[i].strip().split(",")
                                if base_rows[0].strip().upper() != rows[0].strip().upper() or base_rows[1].strip().upper() != rows[1].strip().upper():
                                    flag = False
                            if flag:
                                your_point += 0.5
                                print("Your answer is correct")
                                print("Your points = " + str(your_point))
                            else:
                                print("Your answer is not correct")
                                print("Your points = " + str(your_point))
                    except:
                            print("Your answer has an error")
                            print("Your points = " + str(your_point))                    
                elif index == 1 or index == 6:
                    with open("lab/lab1_" + str(index) + ".csv") as basefile:
                        base_content = basefile.readlines()
                        try:
                            point = int(content[0])
                            base_point = int(base_content[0])
                            if point == base_point:
                                your_point += 0.5
                                print("Your answer is correct")
                                print("Your points = " + str(your_point))
                            else:
                                print("Your answer is not correct")
                                print("Your points = " + str(your_point))
                        except:
                            print("Your answer has an error")
                            print("Your points = " + str(your_point))
                elif index > 1 and index < 6:
                    try:
                        with open("lab/lab1_" + str(index) + ".csv") as basefile:
                            base_content = basefile.readlines()
                            flag = True
                            for i, line in enumerate(base_content):
                                base_rows = line.strip().split(",")
                                rows = content[i].strip().split(",")
                                if base_rows[0].strip().upper() != rows[0].strip().upper() or base_rows[1].strip().upper() != rows[1].strip().upper():
                                    flag = False
                                    break
                            if flag:
                                your_point += 0.5
                                print("Your answer is correct")
                                print("Your points = " + str(your_point))
                            else:
                                print("Your answer is not correct")
                                print("Your points = " + str(your_point))
                    except:
                            print("Your answer has an error")
                            print("Your points = " + str(your_point))
                elif index == 7:
                    try:
                        if "Help" in content[0] or "help" in content[0]:
                            your_point += 0.5
                            print("Your answer is correct")
                            print("Your points = " + str(your_point))
                        else:
                            print("Your answer is not correct")
                            print("Your points = " + str(your_point))
                    except:
                        print("Your answer has an error")
                        print("Your points = " + str(your_point))
                elif index > 7:
                    try:
                        dic = {}
                        with open("lab/lab1_" + str(index) + ".csv") as basefile:
                            base_content = basefile.readlines()
                            flag = True
                            for i, line in enumerate(base_content):
                                base_rows = line.strip().split(",")
                                dic[base_rows[0].strip().upper().replace("<", "").replace(">", "")] = base_rows[1].strip().upper()
                            for i, line in enumerate(content):
                                rows = line.strip().split(",")
                                value = dic.get(rows[0].strip().upper().replace("<", "").replace(">", ""), "Error")
                                if value != rows[1].strip().upper():
                                    flag = False
                                    break
                            if flag:
                                your_point += 1.0
                                print("Your answer is correct")
                                print("Your points = " + str(your_point))
                            else:
                                print("Your answer is not correct")
                                print("Your points = " + str(your_point))
                    except:
                            print("Your answer has an error")
                            print("Your points = " + str(your_point))
    with open("points.csv", "a") as file:
        file.write(iid + "," + str(your_point) + "\n")

