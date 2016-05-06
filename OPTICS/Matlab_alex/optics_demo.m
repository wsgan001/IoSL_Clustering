% Brief Demo to Visualise Optics Results

% Written by Alex Kendall
% University of Cambridge
% 18 Feb 2015
% http://mi.eng.cam.ac.uk/~agk34/

% This software is licensed under GPLv3, see included glpv3.txt.

% ::IMPORTANT:: load your data to 'points'. Here is some example data:
%load('example_data.mat');
%points=[randn(30,2)*.4;randn(40,2)*.5+ones(40,1)*[4 4]];

format long
filename = '..\..\Datasets\2.txt';
delimiterIn = ',';
headerlinesIn = 0;
points = importdata(filename,delimiterIn,headerlinesIn);
size(points);

minpts=5;
epsilon=0.3;
[ SetOfClusters, RD, CD, order ] = cluster_optics(points, minpts, epsilon);

%bar(RD(order));
figure;
class = (-1).^rand(2,10,1);
%hold on;
% Cycle through all clusters
for i=2:length(SetOfClusters)
%    bar(RD(order(SetOfClusters(i).start:SetOfClusters(i).end)));
    if i==2
        plot(RD(order(SetOfClusters(i).start:SetOfClusters(i).end)),'b.');
    elseif i==3
        plot(RD(order(SetOfClusters(i).start:SetOfClusters(i).end)),'r.');
    elseif i==4
        plot(RD(order(SetOfClusters(i).start:SetOfClusters(i).end)),'m.');
    elseif i==5
        plot(RD(order(SetOfClusters(i).start:SetOfClusters(i).end)),'g.');
    elseif i==6
        plot(RD(order(SetOfClusters(i).start:SetOfClusters(i).end)),'y.');
    else
        plot(RD(order(SetOfClusters(i).start:SetOfClusters(i).end)),'y.');
    end
    xlabel('x'), ylabel('y'), title('Clusters Plot');%legend('Cluster');    
    hold on;
    pause(0.4);
end
hold off;

%SetOfClusters