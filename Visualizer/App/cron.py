import time
from .models import Dataset

# Cronjob, delete entries in the database older than 6 hours
def deleteOldEntries() :
    unitl = int(time.time()) - 6*60*60 # 6h * 60m *60s
    Dataset.objects.filter(creationTime<until).delete()
    print("Old Entries deleted")