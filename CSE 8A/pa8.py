from CSE8ACSV import *

blm_protest_data = get_blm_data("blm_state.csv")
tech_diversity_data = get_diversity_data("tech_diversity.csv")
state_populations = get_state_pops()

states = ["Alabama", "Alaska", "Arizona"]

def minimum_blm_protest_attendence(states):
    minimum = 0
    for i in blm_protest_data :
            if blm_protest_data[i] is min :
                minimum += blm_protest_data[i]['TotalAttendacne']
    return minimum



def below_poverty_line(threshold):
    states_list = []

    for stte in blm_protest_data:
        rate = (stte['PovertyRate']) * (state_populations[stte['State']])

        if rate < threshold:
            states_list.append(stte['State'])

    return states_list




def diversity_in_tech(ratio, fields):

    results = {}
    for company in tech_diversity_data:
        resratio = tech_diversity_data[company][fields[0]] / tech_diversity_data[company][fields[1]]
         
        if resratio < ratio:
            results[company] = resratio

    return results



