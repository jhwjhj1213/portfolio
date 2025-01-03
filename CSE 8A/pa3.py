def get_checkin_bags (bag_weights, min_weight, max_weight):
    weight = []
    for bag_weights in bag_weights :
        if bag_weights >=  min_weight and bag_weights <= max_weight :
            weight.append(bag_weights)
    return weight
