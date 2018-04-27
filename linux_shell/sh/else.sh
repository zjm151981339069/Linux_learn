echo "say yes or no"
read timeofday
if [ "$timeofday"="yes" ]
then 
   echo "good morning"
elif [ "$timeofday"="no" ];then
   echo "good afternoon"
else
   echo "sorry"
   exit 1
fi
exit 0

