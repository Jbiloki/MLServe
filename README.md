# MLServe

Using an android interface to communicate with a server to run inputs though an MLP.

MLServe is an android application that was created to test machine learning implementation on android devices using a remote system to run the data though.

# Current algorithms implemented:

## UCI Wisconsin Breast Cancer Data Set:

This dataset is connected and can be used, on the server I have implemented an SVM with Sklearn.

Pre-processing: The data directly from the repository has missing values, to compensate for this the values were replaced with zero at the beginning. After testing I have finalized my preprocessing method to remove all rows with unknown variables. Doing this I only lose about 20 rows of data, a minimal price to pay. The issue with inserting a zero is that we don't want to create our own fake inputs, if the patient has all high numbers and one zero this may confuse the training

Training is done by first shuffling the pre-processed data and seperating it into 50-25-25. 50 percent of our data is being used for training, 25 percent is being used for testing, and 25 percent is being used for validation to prevent overfitting.I am using a linear kernel with C = 20 (penalty parameter) and a random seed to further prevent overfitting.

## Next Steps:

For this data set I have to go though and do riggerous validation testing to ensure the network isn't overfitting. This current network is preliminary to test though the android device, next I will be, try using an SVM instead in order to ensure that I can get the larget margin possible between my classificaiton.

### Update of testing:

First output: Confmat

[[TN, FP]

[FN,TP]]

Second output: Prediction

Third output: Prediction score

Fourth output: Accuracy %

** The input numbers are ignored by validation they are not taking any role here **

![alt tag](http://i.imgur.com/rxNElQD.png)

Images of current product:

In app exlpaination:

![alt tag](http://i.imgur.com/51C3IGj.png)

Prediciton screen with hint's to the parameters:

![alt tag](http://i.imgur.com/iUopJa4.png)

Prediction for a negative result:

![alt tag](http://i.imgur.com/RMVqSVl.png)

Prediction for a positive result:

![alt tag](http://i.imgur.com/3pdi9KS.png)
