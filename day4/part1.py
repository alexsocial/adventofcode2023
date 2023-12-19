class part1:
    def __init__(self):
        self.dat = []
        self.points = 0

    def  __str__(self):
        print(self.points)
    
    def file_to_data(self, f_name: str):
        file = open(f_name)
        for line in file:
            self.dat.append(line)

    """
    Algo:
    Slice the string to remove card number in each line (i.e. slice first 8 characters)
    Split String first by |, then by spaces
    Check if numbers are in winners, then add to points
    O(n^2)
    """
    def process_data(self):
        for line in self.dat:
            temp_points = 0
            nums = line[8:].split("|")
            winners = nums[0].split(" ")
            players = nums[1].split(" ")
            #  Remove extraneous characters
            winners.pop(-1)
            players.pop(0)
            #  Check
            for i in players:
                if i in winners:
                    if temp_points == 0:
                        temp_points += 1
                    else:
                        temp_points *= 2

            self.points += temp_points
        print(self.points)

obj = part1()
obj.file_to_data("day4\data.txt")
obj.process_data()