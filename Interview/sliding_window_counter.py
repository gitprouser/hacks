import datetime
import re



def sliding_window_counter(log_path):
"""
Returns a list of IP addresses that are deemed suspicious. 
This function declaration must be kept unmodified.

Args:
     log_path: The fully qualified path of a log file.
     
Returns:
     A list of IP Addresses.

"""
    suspicious_ip_list = []
    ip_to_timestamp = {}   # dictionary of {'ip': most_recent_request_from_ip_address}
    with open(log_path, 'r') as log_file:
        for line in log_file:
            # (IP_ADDRESS) (USER_ID either 3 digit or 4 digit) (TIME_STAMP) (URL + HTTP_PROTOCOL) (HTTP_CODE) (dont_care)
            # http://stackoverflow.com/questions/8609597/python-regular-expressions-or
            match = re.search('(\d+.\d+.\d+.\d+) - (\d\d\d\d|\d\d\d) (\[.*\]) (".*/account/information.*") (\d\d\d) (.*)', line)
            if match:
                ip = match.group(1)
                time_stamp = match.group(3)[1:-7]   # you are removing the timezone that's why -7, script running on single machine
                """                
                 After a whole bunch of documentation for datetime. See below links most useful:
                       - https://developers.google.com/edu/python/regular-expressions
                       - http://stackoverflow.com/questions/1101508/how-to-parse-dates-with-0400-timezone-string-in-python
                """
                curr = datetime.datetime.strptime(time_stamp, '%d/%b/%Y:%H:%M:%S:%f') 
                http_code = int(match.group(5))
                if 400 <= http_code < 500:
                    # http://stackoverflow.com/questions/1024847/add-new-keys-to-a-dictionary
                    if not ip in ip_to_timestamp.keys():
                        ip_to_timestamp[ip] = curr
                    else:
                        # http://stackoverflow.com/questions/18426882/python-time-difference-in-milliseconds-not-working-for-me
                        # http://stackoverflow.com/questions/1345827/how-do-i-find-the-time-difference-between-two-datetime-objects-in-python
                        diff = (curr - ip_to_timestamp[ip]).total_seconds() * 1000
                        if diff <= 1000:
                            # http://stackoverflow.com/questions/14667578/check-if-a-number-already-exist-in-a-list-in-python
                            if ip not in suspicious_ip_list:
                                suspicious_ip_list.append(ip)
    return suspicious_ip_list  


if __name__ == '__main__':
    print sliding_window_counter('log.log')
