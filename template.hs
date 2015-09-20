import Data.List
import Text.Printf

main :: IO ()
main = interact $
  unlines . zipWith output [1..] . map (solve.words) . tail . lines

output :: Int -> Double -> String
output testCase res = "Case #" ++ show testCase ++ ": " ++ printf "%.10f" res

solve :: [String] -> Double
solve ("mean": x) = (foldl (+) 0 (map read $ tail x)) / (fromIntegral $ ((length x) - 1))
solve ("median": x) = sort (map read $ tail x) !! (quot ((length x) - 1) 2)
