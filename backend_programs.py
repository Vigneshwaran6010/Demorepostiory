#necessary packages
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from flask import Flask,render_template,request,jsonify,redirect,url_for
from sklearn.preprocessing import MinMaxScaler
import tensorflow
from tensorflow import keras
from keras.models import Sequential
from keras.layers import LSTM, Dense
from io import BytesIO
import base64

#Flask 
app = Flask( __name__ )

@app.route('/')
#navigating to home page
def home_page():
    return render_template('home_page.html')

#outputs
#for tata
@app.route('/tata_page.html')
def index():
    
    data = pd.read_csv("C:/Users/WELCOME/OneDrive/Documents/Vicky Project LSTM/tata_dataset.csv")
    data = data['Close'].values.reshape(-1,1)

    # Normalize data
    scaler = MinMaxScaler(feature_range=(0,1))
    scaled_data = scaler.fit_transform(data)

    # Split data into training and testing sets
    train_size = int(len(scaled_data) * 0.8)
    test_size = len(scaled_data) - train_size
    train_data, test_data = scaled_data[0:train_size,:], scaled_data[train_size:len(scaled_data),:]

    # Convert data into sequences
    def create_sequences(data, seq_length):
        X, y = [], []
        for i in range(len(data) - seq_length - 1):
            X.append(data[i:(i+seq_length), 0])
            y.append(data[i + seq_length, 0])
        return np.array(X), np.array(y)

    seq_length = 10
    X_train, y_train = create_sequences(train_data, seq_length)
    X_test, y_test = create_sequences(test_data, seq_length)

    # Reshape data for LSTM input
    X_train = np.reshape(X_train, (X_train.shape[0], X_train.shape[1], 1))
    X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1], 1))

    # Build LSTM model
    model = Sequential()
    model.add(LSTM(units=50, return_sequences=True, input_shape=(X_train.shape[1], 1)))
    model.add(LSTM(units=50))
    model.add(Dense(units=1))

    # Compile model
    model.compile(optimizer='adam', loss='mean_squared_error')

    # Train model
    model.fit(X_train, y_train, epochs=30, batch_size=32)

    # Make predictions
    predictions = model.predict(X_test)
    predictions = scaler.inverse_transform(predictions)

    # Visualize results
    plt.plot(data[train_size + seq_length:len(data)], color='blue', label='Actual Stock Price')
    plt.plot(predictions, color='red', label='Predicted Stock Price')
    plt.title('Stock Price Prediction')
    plt.xlabel('Time')
    plt.ylabel('Stock Price')
    plt.legend()
    
    buf = BytesIO()
    plt.savefig(buf,format = 'png')
    data = base64.b64encode(buf.getbuffer()).decode('ascii')
    html_str = f'<img src = "data:image/png;base64,{data}"alt = "Sample plot">'
    return render_template('tata_page.html',html_str = html_str)


@app.route('/yahoo_page.html')
def yahoo():
    data = pd.read_csv("C:/Users/WELCOME/OneDrive/Documents/Vicky Project LSTM/yahoo_dataset.csv")
    data = data['Close'].values.reshape(-1,1)

        # Normalize data
    scaler = MinMaxScaler(feature_range=(0,1))
    scaled_data = scaler.fit_transform(data)

    # Split data into training and testing sets
    train_size = int(len(scaled_data) * 0.8)
    test_size = len(scaled_data) - train_size
    train_data, test_data = scaled_data[0:train_size,:], scaled_data[train_size:len(scaled_data),:]


    # Convert data into sequences
    def create_sequences(data, seq_length):
        X, y = [], []
        for i in range(len(data) - seq_length - 1):
            X.append(data[i:(i+seq_length), 0])
            y.append(data[i + seq_length, 0])
        return np.array(X), np.array(y)

    seq_length = 10
    X_train, y_train = create_sequences(train_data, seq_length)
    X_test, y_test = create_sequences(test_data, seq_length)


    # Reshape data for LSTM input
    X_train = np.reshape(X_train, (X_train.shape[0], X_train.shape[1], 1))
    X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1], 1))


    # Build LSTM model
    model = Sequential()
    model.add(LSTM(units=50, return_sequences=True, input_shape=(X_train.shape[1], 1)))
    model.add(LSTM(units=50,return_sequences=True))
    model.add(LSTM(units=50))
    model.add(Dense(units=1))

    # Compile model
    model.compile(optimizer='adam', loss='mean_squared_error')

    # Train model
    model.fit(X_train, y_train,epochs=75, batch_size=32)

    # Make predictions
    predictions = model.predict(X_test)
    predictions = scaler.inverse_transform(predictions)

    # Visualize results
    plt.plot(data[train_size + seq_length:len(data)], color='blue', label='Actual Stock Price')
    plt.plot(predictions, color='red', label='Predicted Stock Price')
    plt.title('Stock Price Prediction')
    plt.xlabel('Time')
    plt.ylabel('Stock Price')
    plt.legend()
    
    buf = BytesIO()
    plt.savefig(buf,format = 'png')
    data = base64.b64encode(buf.getbuffer()).decode('ascii')
    html_str = f'<img src = "data:image/png;base64,{data}"alt = "Sample plot">'
    return render_template('yahoo_page.html',html_str = html_str)

@app.route('/reliance_page.html')
def reliance():
    data = pd.read_csv("C:/Users/WELCOME/OneDrive/Documents/Vicky Project LSTM/reliance_dataset.csv")
    data

    data.dropna()

    data = data['Close'].values.reshape(-1,1)

    scale = MinMaxScaler(feature_range=(0,1))
    scaled_data = scale.fit_transform(data)

    train_size = int(len(scaled_data) * 0.75)
    train_data = scaled_data[:train_size]
    test_data = scaled_data[train_size:]

    def create_seq(data,seq_length):
        X = []
        Y = []
        for i in range(len(data)-seq_length):
            X.append(data[i:i+seq_length])
            Y.append(data[i+seq_length])
        return np.array(X),np.array(Y)

    seq_length = 20
    X_train,Y_train = create_seq(train_data,seq_length)
    X_test,Y_test = create_seq(test_data,seq_length)

    model = Sequential()
    model.add(LSTM(50,return_sequences = True, input_shape = (seq_length,1)))
    model.add(LSTM(50))
    model.add(Dense(1))
    model.compile(optimizer = 'adam',loss='mean_squared_error')

    model.fit(X_train,Y_train,epochs=50,batch_size=40)

    model.fit(X_train,Y_train,epochs=50,batch_size=40)

    train_predictions = model.predict(X_train)
    test_predictions = model.predict(X_test)

    train_predictions = scale.inverse_transform(train_predictions)
    test_predictions = scale.inverse_transform(test_predictions)

    plt.plot(data[train_size + seq_length:len(data)], color='blue', label='Actual Stock Price')
    plt.plot(test_predictions, color='red', label='Predicted Stock Price')
    plt.title('Stock Price Prediction')
    plt.xlabel('Time')
    plt.ylabel('Stock Price')
    plt.legend()

    buf = BytesIO()
    plt.savefig(buf,format = 'png')
    data = base64.b64encode(buf.getbuffer()).decode('ascii')
    html_str = f'<img src = "data:image/png;base64,{data}"alt = "Sample plot">'
    return render_template('reliance_page.html',html_str = html_str)

if __name__ == '__main__':
    app.run(debug=True, use_reloader = False)