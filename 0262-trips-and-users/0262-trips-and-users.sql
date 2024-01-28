# Write your MySQL query statement below
select request_at as Day, round(count(if(status = "cancelled_by_client" or status = "cancelled_by_driver", 1, NULL)) / count(*), 2) as "Cancellation Rate"
from Trips
where client_id not in (select users_id from Users where banned = "Yes") and
      driver_id not in (select users_id from Users where banned = "Yes") and
      request_at >= "2013-10-01" and request_at <= "2013-10-03"
group by request_at