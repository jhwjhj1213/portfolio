bird_list = ['California quail', 'Blue Jay', 'Gyrfalcon', 'Blue Jay']

career_points = {'LeBron James': 35516, 'Kawhi Leonard': 11085, 'Joel Embiid': 6649, 'Jayson Tatum': 5923}
recent_game = [('LeBron James', 28), ('Joel Embiid', 14) ]

def bird_distribution (bird_list) :
    list_distbird = {}
    
    for bird in bird_list :
        if bird not in list_distbird :
            list_distbird[bird] = 0
        list_distbird[bird] += 1
        
    return list_distbird

def busy_rooms (meetings, threshold):
    list_distburo = {}
    
    for key in meetings :
        if len(meetings[key]) >= threshold :
            list_distburo[key] = meetings[key]

    return list_distburo

def update_stats (career_points, recent_game) :
    
    for key, value in recent_game:
        if key not in career_points :
            career_points[key] = 0
        career_points[key] += value
        
    return career_points
