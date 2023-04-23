import pandas as pd

import matplotlib.pyplot as plt

DS2_band_without_pivot = pd.read_csv('../test_data/DS2_band_without_pivot.txt', delimiter=',')
DS2_dense_without_pivot = pd.read_csv('../test_data/DS2_dense_without_pivot.txt', delimiter=',')
DS2_sparse_without_pivot = pd.read_csv('../test_data/DS2_sparse_without_pivot.txt', delimiter=',')
DS2_band_with_pivot = pd.read_csv('../test_data/DS2_band_with_pivot.txt', delimiter=',')
DS2_dense_with_pivot = pd.read_csv('../test_data/DS2_dense_with_pivot.txt', delimiter=',')
DS2_sparse_with_pivot = pd.read_csv('../test_data/DS2_sparse_with_pivot.txt', delimiter=',')

DS3_band_without_pivot = pd.read_csv('../test_data/DS3_band_without_pivot.txt', delimiter=',')
DS3_dense_without_pivot = pd.read_csv('../test_data/DS3_dense_without_pivot.txt', delimiter=',')
DS3_sparse_without_pivot = pd.read_csv('../test_data/DS3_sparse_without_pivot.txt', delimiter=',')
DS3_band_with_pivot = pd.read_csv('../test_data/DS3_band_with_pivot.txt', delimiter=',')
DS3_dense_with_pivot = pd.read_csv('../test_data/DS3_dense_with_pivot.txt', delimiter=',')
DS3_sparse_with_pivot = pd.read_csv('../test_data/DS3_sparse_with_pivot.txt', delimiter=',')

apache_band = pd.read_csv('../test_data/apache_band.txt', delimiter=',')
apache_dense = pd.read_csv('../test_data/apache_dense.txt', delimiter=',')
apache_sparse = pd.read_csv('../test_data/apache_sparse.txt', delimiter=',')

print("DS2 band non pivot")

print('\n')

print("Absolute error")
print(DS2_band_without_pivot.iloc[:, 0].mean())
print(DS2_band_without_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS2_band_without_pivot.iloc[:, 1].mean())
print(DS2_band_without_pivot.iloc[:, 1].median())

print('\n')

print("DS2 dense non pivot")

print('\n')

print("Absolute error")
print(DS2_dense_without_pivot.iloc[:, 0].mean())
print(DS2_dense_without_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS2_dense_without_pivot.iloc[:, 1].mean())
print(DS2_dense_without_pivot.iloc[:, 1].median())

print('\n')

print("DS2 sparse non pivot")

print('\n')

print("Absolute error")
print(DS2_sparse_without_pivot.iloc[:, 0].mean())
print(DS2_sparse_without_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS2_sparse_without_pivot.iloc[:, 1].mean())
print(DS2_sparse_without_pivot.iloc[:, 1].median())

print('\n')

print("DS2 band pivot")

print('\n')

print("Absolute error")
print(DS2_band_with_pivot.iloc[:, 0].mean())
print(DS2_band_with_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS2_band_with_pivot.iloc[:, 1].mean())
print(DS2_band_with_pivot.iloc[:, 1].median())

print('\n')

print("DS2 dense pivot")

print('\n')

print("Absolute error")
print(DS2_dense_with_pivot.iloc[:, 0].mean())
print(DS2_dense_with_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS2_dense_with_pivot.iloc[:, 1].mean())
print(DS2_dense_with_pivot.iloc[:, 1].median())

print('\n')

print("DS2 sparse pivot")

print('\n')

print("Absolute error")
print(DS2_sparse_with_pivot.iloc[:, 0].mean())
print(DS2_sparse_with_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS2_sparse_with_pivot.iloc[:, 1].mean())
print(DS2_sparse_with_pivot.iloc[:, 1].median())

print('\n')

print("DS3 band non pivot")

print('\n')

print("Absolute error")
print(DS3_band_without_pivot.iloc[:, 0].mean())
print(DS3_band_without_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS3_band_without_pivot.iloc[:, 1].mean())
print(DS3_band_without_pivot.iloc[:, 1].median())

print('\n')

print("DS3 dense non pivot")

print('\n')

print("Absolute error")
print(DS3_dense_without_pivot.iloc[:, 0].mean())
print(DS3_dense_without_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS3_dense_without_pivot.iloc[:, 1].mean())
print(DS3_dense_without_pivot.iloc[:, 1].median())

print('\n')

print("DS3 sparse non pivot")

print('\n')

print("Absolute error")
print(DS3_sparse_without_pivot.iloc[:, 0].mean())
print(DS3_sparse_without_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS3_sparse_without_pivot.iloc[:, 1].mean())
print(DS3_sparse_without_pivot.iloc[:, 1].median())

print('\n')

print("DS3 band pivot")

print('\n')

print("Absolute error")
print(DS3_band_with_pivot.iloc[:, 0].mean())
print(DS3_band_with_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS3_band_with_pivot.iloc[:, 1].mean())
print(DS3_band_with_pivot.iloc[:, 1].median())

print('\n')

print("DS3 dense pivot")

print('\n')

print("Absolute error")
print(DS3_dense_with_pivot.iloc[:, 0].mean())
print(DS3_dense_with_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS3_dense_with_pivot.iloc[:, 1].mean())
print(DS3_dense_with_pivot.iloc[:, 1].median())

print('\n')

print("DS3 sparse pivot")

print('\n')

print("Absolute error")
print(DS3_sparse_with_pivot.iloc[:, 0].mean())
print(DS3_sparse_with_pivot.iloc[:, 0].median())

print('\n')

print("relative error")
print(DS3_sparse_with_pivot.iloc[:, 1].mean())
print(DS3_sparse_with_pivot.iloc[:, 1].median())

print("apache band pivot")

print('\n')

print("Absolute error")
print(apache_band.iloc[:, 0].mean())
print(apache_band.iloc[:, 0].median())

print('\n')

print("relative error")
print(apache_band.iloc[:, 1].mean())
print(apache_band.iloc[:, 1].median())

print('\n')

print("apache dense")

print('\n')

print("Absolute error")
print(apache_dense.iloc[:, 0].mean())
print(apache_dense.iloc[:, 0].median())

print('\n')

print("relative error")
print(apache_dense.iloc[:, 1].mean())
print(apache_dense.iloc[:, 1].median())

print('\n')

print("apache sparse")

print('\n')

print("Absolute error")
print(apache_sparse.iloc[:, 0].mean())
print(apache_sparse.iloc[:, 0].median())

print('\n')

print("relative error")
print(apache_sparse.iloc[:, 1].mean())
print(apache_sparse.iloc[:, 1].median())

ascending_ds2_band = pd.read_csv('../test_data_ascending_size/DS2_band_with_pivot.txt', delimiter=',')
ascending_ds2_dense = pd.read_csv('../test_data_ascending_size/DS2_dense_with_pivot.txt', delimiter=',')
ascending_ds2_sparse = pd.read_csv('../test_data_ascending_size/DS2_sparse_with_pivot.txt', delimiter=',')

ascending_ds3_band = pd.read_csv('../test_data_ascending_size/DS3_band_with_pivot.txt', delimiter=',')
ascending_ds3_dense = pd.read_csv('../test_data_ascending_size/DS3_dense_with_pivot.txt', delimiter=',')
ascending_ds3_sparse = pd.read_csv('../test_data_ascending_size/DS3_sparse_with_pivot.txt', delimiter=',')

ascending_apache_band = pd.read_csv('../test_data_ascending_size/apache_band.txt', delimiter=',')
ascending_apache_dense = pd.read_csv('../test_data_ascending_size/apache_dense.txt', delimiter=',')
ascending_apache_sparse = pd.read_csv('../test_data_ascending_size/apache_sparse.txt', delimiter=',')

#
# base = list(range(30, 50))
#
# plt.plot(base, list(ascending_ds2_band.iloc[:, 1]), label='Band')
# plt.plot(base, list(ascending_ds2_dense.iloc[:, 1]), label='Dense')
# plt.plot(base, list(ascending_ds2_sparse.iloc[:, 1]), label='Sparse')
# plt.xticks(range(30, 51, 5))
# plt.title("DS2 A2 dla rosnącej wielkości macierzy")
# plt.xlabel('Wymiary macierzy')
# plt.ylabel('Błąd przybliżenia')
# plt.legend() # dodanie legendy
#
# plt.show()


# print(list(ascending_ds2_band.iloc[:, 1]))
# print(base)


# print("DS2 band non pivot")
# print('\n')
# print(DS2_band_without_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS2 dense non pivot")
# print('\n')
# print(DS2_dense_without_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS2 sparse non pivot")
# print('\n')
# print(DS2_sparse_without_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS2 band pivot")
# print('\n')
# print(DS2_band_with_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS2 dense pivot")
# print('\n')
# print(DS2_dense_with_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS2 sparse pivot")
# print('\n')
# print(DS2_sparse_with_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS3 band non pivot")
# print('\n')
# print(DS3_band_without_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS3 dense non pivot")
# print('\n')
# print(DS3_dense_without_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS3 sparse non pivot")
#
# print('\n')
# print(DS3_sparse_without_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS3 band pivot")
# print('\n')
# print(DS3_band_with_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS3 dense pivot")
# print('\n')
# print(DS3_dense_with_pivot.iloc[:, 2].mean())
# print('\n')
#
# print("DS3 sparse pivot")
# print('\n')
# print(DS3_sparse_with_pivot.iloc[:, 2].mean())
# print('\n')
#
#
# print("apache band pivot")
# print('\n')
# print(apache_band.iloc[:, 2].mean())
# print('\n')
#
# print("apache dense")
# print('\n')
# print(apache_dense.iloc[:, 2].mean())
# print('\n')
#
# print("apache sparse")
# print('\n')
# print(apache_sparse.iloc[:, 2].mean())
# print('\n')


base = list(range(30, 60))

# plt.plot(base, list(ascending_ds2_band.iloc[:, 2]), label='Band')
plt.plot(base, list(ascending_ds2_dense.iloc[:, 2]), label='DS2')
plt.plot(base, list(ascending_ds3_dense.iloc[:, 2]), label='DS3')
# plt.plot(base, list(ascending_ds2_sparse.iloc[:, 2]), label='Sparse')
plt.xticks(range(30, 60, 5))
plt.title("Porównanie czasu obliczenia macierzy gęstych dla różnych implementacji")
plt.xlabel('Wymiary macierzy')
plt.ylabel('Czas[ns]')
plt.legend()  # dodanie legendy

plt.show()


base = list(range(30, 60))

# plt.plot(base, list(ascending_ds2_band.iloc[:, 2]), label='Band')
plt.plot(base, list(ascending_ds2_band.iloc[:, 2]), label='DS2')
plt.plot(base, list(ascending_ds3_band.iloc[:, 2]), label='DS3')
# plt.plot(base, list(ascending_ds2_sparse.iloc[:, 2]), label='Sparse')
plt.xticks(range(30, 60, 5))
plt.title("Porównanie czasu obliczenia macierzy wstęgowych dla różnych implementacji")
plt.xlabel('Wymiary macierzy')
plt.ylabel('Czas[ns]')
plt.legend()  # dodanie legendy

plt.show()



base = list(range(30, 60))

# plt.plot(base, list(ascending_ds2_band.iloc[:, 2]), label='Band')
plt.plot(base, list(ascending_ds2_sparse.iloc[:, 2]), label='DS2')
plt.plot(base, list(ascending_ds3_sparse.iloc[:, 2]), label='DS3')
# plt.plot(base, list(ascending_ds2_sparse.iloc[:, 2]), label='Sparse')
plt.xticks(range(30, 60, 5))
plt.title("Porównanie czasu obliczenia macierzy rzadkich dla różnych implementacji")
plt.xlabel('Wymiary macierzy')
plt.ylabel('Czas[ns]')
plt.legend()  # dodanie legendy

plt.show()
